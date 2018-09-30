package tn.esprit.pidevjee.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.pidevjee.interfaces.CommentServiceLocal;

import tn.esprit.pidevjee.persistence.Comment;
import tn.esprit.pidevjee.persistence.Document;
import tn.esprit.pidevjee.persistence.Task;
import tn.esprit.pidevjee.persistence.User;

@Stateless
@LocalBean
public class CommentService implements CommentServiceLocal {

	@PersistenceContext
	EntityManager em;

	@Override
	public long documentNonValideJPQL() {
		Query query = em.createQuery("SELECT COUNT(e.id) from Document e where e.etatdoc='nonvalide'");
		return (long) query.getSingleResult();
	}

	public long documentValideJPQL() {
		Query query = em.createQuery("SELECT COUNT(e.id) from Document e where e.etatdoc='valide'");
		return (long) query.getSingleResult();

	}

	@Override
	public int ajouterCommentaire(Comment commentaire) {
		try {
			em.persist(commentaire);
			return 1;
		} catch (Exception e) {
			e.getStackTrace();
			return 0;
		}

	}

	@Override
	public void supprimerCommentaire(int id) {

		Comment commentaire = em.find(Comment.class, id);
		System.out.println("employe:" + commentaire);
		em.remove(commentaire);
	}

	@Override
	public List<Comment> showCommentairebyDocument(int idDocument) {

		TypedQuery<Comment> query = em.createQuery("SELECT c FROM comment c ,document d WHERE c.documment_id=:d.id",
				Comment.class);
		query.setParameter("var", idDocument);

		return query.getResultList();
	}

	// @Override
	// public List <Comment> getAllEmploye() {
	// List<Comment> commentaires =null;
	// TypedQuery <Comment> query= em.createQuery("select e from Comment e where
	// e.documment=1 ",Comment.class);
	// commentaires = query.getResultList();
	// System.out.println("commentaires:"+commentaires.size());
	// return commentaires;
	// }

	@Override
	public List<Comment> getAllEmploye() {
		List<Comment> commentaires = null;
		TypedQuery<Comment> query = em.createQuery("select c from Comment c", Comment.class);
		commentaires = query.getResultList();
		System.out.println("commentaires:" + commentaires.size());
		return commentaires;
	}

	// @Override
	// public void updateComment(int idc, String desc) {
	// Comment c = em.find(Comment.class, idc);
	// c.setDescription(desc);
	// em.merge(c);
	// }

	public Document findDocumentbyid(int id) {
		Document d = em.find(Document.class, id);
		return d;

	}

	public User findUserbyid(int id) {
		User u = em.find(User.class, id);
		return u;

	}

	@Override
	public void updateComment(Comment c) {
		em.merge(c);
	}

}
