package tn.esprit.pidevjee.presentation.mbeans;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;


import tn.esprit.pidevjee.persistence.etat;
import tn.esprit.pidevjee.services.DocumentService;
import tn.esprit.pidevjee.persistence.Document;
import tn.esprit.pidevjee.persistence.User;


@ManagedBean
@ViewScoped
public class DocumentBean {
	private Part file1;
	private Part file2;
	private int ids;
	private String paths;
	private String names;
	private etat etats;
	private List<User> Users;
	private List<Document> Documents;
	private int selectedUserId;
	private Date date;
	private Part file;
	
	private String x;
	
	public String Uploadfile() throws IOException{
		file1.write("C:\\data\\"+getFilename(file1));
		file2.write("C:\\data\\"+getFilename(file2));
		return"affichage";
	}
	private static String getFilename(Part part){
		for (String od : part.getHeader("content-disposition").split(";")){
			if (od.trim().startsWith("filename")){
				String filename = od.substring(od.indexOf('=') +1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);		
			}
		}
		return null;
	}
	@EJB
	DocumentService DocumentService ;
	
	@EJB
	tn.esprit.pidevjee.services.UserService userService;
	
	public void supprimer(int ids)
	{
		DocumentService.deleteDocumentById(ids);
		
	}
	public void supprimerbypath(String paths){			
			File f = new File(paths);
			f.delete();	
	}
	public List<Document> getAllDocument(){
		  Documents = DocumentService.getAllDocs();
		  System.out.println(Documents);
		   return Documents;
	   }
	public String redirection(){
		return "newcomment";
	}
	public String ajouterDocument() throws ParseException
	{	
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("aaaaaa" + simpleFormat.format(date));
		System.out.println("bbbb"+ selectedUserId);
		Document document = new Document(ids,"C:\\data\\"+getFilename(file1),names,date,etats);
		User selectedUser = new User();
		selectedUser.setId(selectedUserId);
		document.setUser(selectedUser);
		DocumentService.create(document);
		return"Upload";
	}
	public List<User> AffUser()
	{
	return	userService.getAllUsers();
	}

	public int getIds() {
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	public String getPaths() {
		return paths;
	}
	public void setPaths(String paths) {
		this.paths = paths;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public etat getEtats() {
		return etats;
	}
	public void setEtats(etat etats) {
		this.etats = etats;
	}
	public List<User> getUsers() {
		return Users;
	}
	public void setUsers(List<User> users) {
		Users = users;
	}
	public List<Document> getDocuments() {
		return Documents;
	}
	public void setDocuments(List<Document> documents) {
		Documents = documents;
	}
	public int getSelectedUserId() {
		return selectedUserId;
	}
	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
	}

	public Part getFile2() {
		return file2;
	}

	public void setFile2(Part file2) {
		this.file2 = file2;
	}
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}

}
