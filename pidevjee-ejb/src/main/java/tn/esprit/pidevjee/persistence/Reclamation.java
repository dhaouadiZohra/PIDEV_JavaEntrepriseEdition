package tn.esprit.pidevjee.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reclamation implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String sujet;
	private EtatRec etat;
	
	@ManyToOne
	private User utilisateurs;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public EtatRec getEtat() {
		return etat;
	}
	public void setEtat(EtatRec etat) {
		this.etat = etat;
	}
	public Reclamation(String sujet, EtatRec etat) {
		super();
		this.sujet = sujet;
		this.etat = etat;
		
		
		
		
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
