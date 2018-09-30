package tn.esprit.pidevjee.interfaces;

import java.util.List;



import javax.ejb.Remote;

import tn.esprit.pidevjee.persistence.Mail;

@Remote
public interface InterfaceMailServiceRemote {
	
	 
	 
	 public void MailDeleteByID(Integer mailID);
	 public List<Mail> getSent();

	 public int ajoutermail(Mail mail);
	 public List<Mail> getReceived(int id);
	 public boolean supprimermail(int id);
	 /*
	 private static String getFileName(Part part);
*/
	 public Mail getMailById(int id);
}
