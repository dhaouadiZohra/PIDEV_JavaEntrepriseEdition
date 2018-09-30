package tn.esprit.pidevjee.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conger implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String motif; 
	private int duree;
	private String type;
	private Date fromdate;
	private Date  todate;
	private String state;
	@ManyToOne
	private User u;
	public Conger(String motif, int duree, String type, Date fromdate, Date todate, String state, User u) {
		super();
		this.motif = motif;
		this.duree = duree;
		this.type = type;
		this.fromdate = fromdate;
		this.todate = todate;
		this.state = state;
		this.u = u;
	}
	public Conger() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
	
	
	
	




	
	
	
	
	
	
	
	

}
