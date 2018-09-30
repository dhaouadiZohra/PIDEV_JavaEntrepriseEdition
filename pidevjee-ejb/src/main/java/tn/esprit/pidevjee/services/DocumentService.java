package tn.esprit.pidevjee.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidevjee.interfaces.InterfaceDocumentServiceRemote;
import tn.esprit.pidevjee.persistence.Document;
import tn.esprit.pidevjee.persistence.User;


@Stateless
@LocalBean
public class DocumentService implements InterfaceDocumentServiceRemote {
	@PersistenceContext
	private EntityManager em;

    public DocumentService() {
    }
    @Override
    public void create(Document doc) {
		em.persist(doc);
	}
    @Override
    public List<Document> getAllDocs() {
		
		TypedQuery<Document> query = em.createQuery("select u from Document u ",Document.class);	
		 List<Document> docs = query.getResultList();
		 return docs;
	}
    public void AffectDocumentUser (int uid , int did){
    	User u = em.find(User.class, uid);
    	Document d = em.find(Document.class, did);
    	d.setUser(u);
    	
    }
    @Override
    public boolean deleteDocumentById(int did)
	{
		Document doc = em.find(Document.class, did);
		try {
			em.remove(doc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}}






 public Document getDocById(int id) {
		Document doc = em.find(Document.class, id);
		
		
		return doc ;
	}
   

}
