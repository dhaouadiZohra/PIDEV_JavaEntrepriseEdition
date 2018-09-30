package tn.esprit.pidevjee.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Document implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String path;
	private String name;
	private Date datesubmit;
	private etat etat;
	
	
	@ManyToOne
	private User user;
	
	public Document(int id, String path, String name, Date datesubmit,etat etat) {
		super();
		this.id = id;
		this.path = path;		
		this.name = name;
		this.datesubmit = datesubmit;
		this.etat=etat;
	}
	public Document() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDatesubmit() {
		return datesubmit;
	}
	public void setDatesubmit(Date datesubmit) {
		this.datesubmit = datesubmit;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public etat getEtat() {
		return etat;
	}
	public void setEtat(etat etat) {
		this.etat = etat;
	}
	
	
	

}
