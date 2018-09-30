package tn.esprit.pidevjee.persistence;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.pidevjee.persistence.User;
@Entity
public class Mail implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String subject;
	private Date sentdate;
	private String context;
	private String path;
	@ManyToOne
	private User receiver;
	@ManyToOne
	private User sender;

	
	public Mail(String subject, Date sentdate, String context, User receiver, User sender) {
		super();
		this.subject = subject;
		this.sentdate = sentdate;
		this.context = context;
		this.receiver = receiver;
		this.sender = sender;
	}
	public Mail(String subject, Date sentdate, String context, User receiver, User sender,String path) {
		super();
		this.subject = subject;
		this.sentdate = sentdate;
		this.context = context;
		this.receiver = receiver;
		this.sender = sender;
		this.path=path;
	}

	public Mail() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Mail(int id, String subject, Date sentdate, String context, User receiver, User sender) {
		super();
		this.id = id;
		this.subject = subject;
		this.sentdate = sentdate;
		this.context = context;
		this.receiver = receiver;
		this.sender = sender;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	public Date getSentdate() {
		return sentdate;
	}
	public void setSentdate(Date sentdate) {
		this.sentdate = sentdate;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	@JsonIgnore
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
	
	

}
