package tn.esprit.pidevjee.services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import tn.esprit.pidevjee.interfaces.InterfaceUserServiceRemote;
import tn.esprit.pidevjee.persistence.User;

@Stateless
@LocalBean
public class UserService implements InterfaceUserServiceRemote{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public int AjouterUser(User User) {
		em.persist(User);
		return User.getId();
	}

	public User getUserByLoginAndPassword(String login, String password){
		User user = null;
		Query query;
		try{
			query = em.createQuery("select u from User u where u.login=:login and u.password=:password");
			query.setParameter("login", login);
			query.setParameter("password", password);
			user = (User)query.getSingleResult();
		}catch(NonUniqueResultException | NoResultException e){
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		TypedQuery<User> query = em.createQuery("select u from User u "+
				"where u.email=:email and "+
						"u.password=:password " ,User.class);
				query.setParameter("email",email);
				query.setParameter("password", password);
				User user = null;
				try{
					user=query.getSingleResult();
				}catch(NoResultException e){
					Logger.getGlobal().info("Aucun employe trouve avec amail: " + email);
					
				}
				return user;
	}
	
	@Override
	 public List<User> getAllUsers() {
		
		TypedQuery<User> query = em.createQuery("select u from User u ",User.class);	
		 List<User> user = query.getResultList();
		 return user;
	}
	@Override
	public void UserDeleteByID(Integer userID) {
	
		Query query = em.createQuery("delete from User u where u.id=:userID");	
		query.setParameter("userID", userID);
		query.executeUpdate();
	}
	@Override
	public String getAllEmailFromDB(String emailE){
		Query query=em.createQuery("select u from tn.esprit.pidev.persistence.User u where u.email=(:email)");
		query.setParameter("emailE", emailE);
		
		 return (String)query.getParameterValue(emailE);
		
	}

	
	
	@Override
	public void updateUser(User User) {
		em.merge(User);
		
	}

}
