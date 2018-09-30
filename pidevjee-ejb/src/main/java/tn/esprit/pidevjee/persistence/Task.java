package tn.esprit.pidevjee.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String state;
	@Temporal(TemporalType.DATE)
	@Future
	private Date deadline;
	
	@OneToOne
	private Alert alert;
	@JsonIgnore
	@ManyToOne
	private User user;
	
	
	
	
	public Task(int id, String name, String description, Date deadline) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.deadline = deadline;
	}
	
	
	
	
	
	
	public Task(int id, String name, String description, Date deadline,String state, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.state = state;
		this.deadline = deadline;
		this.user = user;
	}






	public Task() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Alert getAlert() {
		return alert;
	}
	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Task(String name, String description, Date deadline) {
		super();
		this.name = name;
		this.description = description;
		this.deadline = deadline;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	

}
