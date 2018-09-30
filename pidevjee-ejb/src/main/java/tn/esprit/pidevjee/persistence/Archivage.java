package tn.esprit.pidevjee.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Archivage implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String path;
	private String name;
	private Date datesubmit;
	private etat etat;
	@ManyToOne
	private User user;
	private String version ;
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
	public etat getEtat() {
		return etat;
	}
	public void setEtat(etat etat) {
		this.etat = etat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Archivage() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
