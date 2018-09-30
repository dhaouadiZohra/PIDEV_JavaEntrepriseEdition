package tn.esprit.pidevjee.interfaces;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.pidevjee.persistence.Comment;
import tn.esprit.pidevjee.persistence.Document;
import tn.esprit.pidevjee.persistence.User;

@Local
public interface CommentServiceLocal {
public long documentNonValideJPQL();
	public int ajouterCommentaire(Comment commentaire);

	public void supprimerCommentaire(int commentaireId);

	
	public void updateComment(Comment comment);
	
	public List<Comment> showCommentairebyDocument(int  idDocument);
	 
	public Document findDocumentbyid(int id);
	
	public User findUserbyid(int id);
	
	 
	public List <Comment> getAllEmploye() ;
	
	public long documentValideJPQL();
	

}
