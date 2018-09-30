package tn.esprit.pidevjee.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidevjee.persistence.User;



@Remote
public interface InterfaceUserServiceRemote {
	
	public int AjouterUser(User User);
	public User getUserByEmailAndPassword(String email,String password);
	public List<User> getAllUsers() ;
	public void UserDeleteByID(Integer userID);
	public String getAllEmailFromDB(String emailE);
	public void updateUser(User User);

}
