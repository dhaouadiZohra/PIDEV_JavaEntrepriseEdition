package tn.esprit.pidevjee.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Participate implements Serializable {
	@ManyToOne
	@JoinColumn(name="iduser",referencedColumnName="id",insertable=false,updatable=false)
	private User user;
	@ManyToOne
	@JoinColumn(name="idevent",referencedColumnName="id",insertable=false,updatable=false)
	private Evenement event;
	@EmbeddedId
	private ParticipatePK participatePk;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Evenement getEvent() {
		return event;
	}
	public void setEvent(Evenement event) {
		this.event = event;
	}
	public ParticipatePK getParticipatePk() {
		return participatePk;
	}
	public void setParticipatePk(ParticipatePK participatePk) {
		this.participatePk = participatePk;
	}
	public Participate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
