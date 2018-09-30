package tn.esprit.pidevjee.persistence;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Evenement implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private Time heure;
	private String localisation;
	private Integer nbrmaxpart;
	@ManyToMany
	private List<User> user;
	
	
	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Evenement(int id, String titre, String description, Date dateDebut, Date dateFin, Time heure,
			String localisation, Integer nbrmaxpart) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.heure = heure;
		this.localisation = localisation;
		this.nbrmaxpart = nbrmaxpart;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public Time getHeure() {
		return heure;
	}



	public void setHeure(Time heure) {
		this.heure = heure;
	}



	public String getLocalisation() {
		return localisation;
	}



	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}



	public Integer getNbrmaxpart() {
		return nbrmaxpart;
	}



	public void setNbrmaxpart(Integer nbrmaxpart) {
		this.nbrmaxpart = nbrmaxpart;
	}
	
	
	

}
