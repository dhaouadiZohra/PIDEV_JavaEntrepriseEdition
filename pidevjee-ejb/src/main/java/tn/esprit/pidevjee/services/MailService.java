package tn.esprit.pidevjee.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

import tn.esprit.pidevjee.interfaces.InterfaceMailServiceRemote;

import tn.esprit.pidevjee.persistence.Mail;
import tn.esprit.pidevjee.persistence.User;


@Stateless
@LocalBean
public class MailService implements InterfaceMailServiceRemote {
	@PersistenceContext
	private EntityManager em;

    public MailService() {
    }
    @Override
    public int ajoutermail(Mail mail) {
		em.persist(mail);
		return mail.getId();
	}
    @Override
    public List<Mail> getReceived(int id){
        User user=em.find(User.class, id);
    	TypedQuery<Mail> query = em.createQuery("select m from Mail m where m.sender=:sender",Mail.class);	
		 List<Mail> mail = query.setParameter("sender", user).getResultList();
		 return mail;
	}
    @Override
	 public List<Mail> getSent() {
		
		 TypedQuery<Mail> query = em.createQuery("select m from Mail m",Mail.class);	
		 List<Mail> mail = query.getResultList();
		 return mail;
	}
	@Override
	public void MailDeleteByID(Integer mailID) {
	
		Query query = em.createQuery("delete from Mail m where m.id=:mailID");	
		query.setParameter("mailID", mailID);
		query.executeUpdate();
	}
	public User getUserById(int id){
		User user=em.find(User.class, id);
		return user;
		
	}
	/*
	public User getUserByMail(String email){
		TypedQuery<User> query=em.createQuery("select u from User u where u.email=:email",User.class);
		User user=query.setParameter("email", email).getSingleResult();
		
		return user;
		
	}
	*/
	
	@Override
	public boolean supprimermail(int id) {

   Mail mail = em.find(Mail.class,id);
   System.out.println("Mail:"+mail);
   em.remove(mail);
   return true;
   }
	
	
	
	
	
	@Override
	public Mail getMailById(int id){
		Mail mail=em.find(Mail.class, id);
		return mail;
		
	}
	
	
	
}
