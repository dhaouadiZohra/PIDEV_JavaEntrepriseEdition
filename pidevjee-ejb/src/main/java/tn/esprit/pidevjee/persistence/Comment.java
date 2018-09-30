package tn.esprit.pidevjee.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String description;
	//@Temporal(TemporalType.DATE)
	@JsonIgnore
	private Date postdate;
	
	@JsonIgnore
	@ManyToOne
	private User utilisateur;
	@JsonIgnore
	@ManyToOne 
	private Document documment;
	
	
	public Comment( String description) {
		super();
		
		this.description = description;
	
	}
	
	
	
	public Comment(String description, Date postdate) {
		super();
		this.description = description;
		this.postdate = new Date();
	}



	public Comment(String description, User utilisateur, Document documment) {
		super();
		this.description = description;
		this.utilisateur = utilisateur;
		this.documment = documment;
	}



	public Comment(int id, String description, Date postdate, User utilisateur) {
		super();
		this.id = id;
		this.description = description;
		this.postdate = postdate;
		this.utilisateur = utilisateur;
	}



	public Comment() {
		super();
	}
	public Comment(String description, Integer id) {
		this.description=description;
		this.id=id;
	}



	



	public Comment(int id, String description, Document documment) {
		super();
		this.id = id;
		this.description = description;
		this.documment = documment;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Document getDocumment() {
		return documment;
	}



	


	@Override
	public String toString() {
		return "Comment [id=" + id + ", description=" + description + ", postdate=" + postdate + ", utilisateur="
				+ utilisateur + ", documment=" + documment + "]";
	}



	public void setDocumment(Document documment) {
		this.documment = documment;
	}
	
	
	
	
}
