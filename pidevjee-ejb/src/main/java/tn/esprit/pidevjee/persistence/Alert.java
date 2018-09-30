package tn.esprit.pidevjee.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import tn.esprit.pidevjee.persistence.Task;
@Entity
public class Alert implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String alertcontext;
	private Date alertdate;
	
	@OneToOne(mappedBy="alert")
	 private Task task;
	
	public Alert(int id, String alertcontext, Date alertdate) {
		super();
		this.id = id;
		this.alertcontext = alertcontext;
		this.alertdate = alertdate;
	}
	
	public Alert() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlertcontext() {
		return alertcontext;
	}
	public void setAlertcontext(String alertcontext) {
		this.alertcontext = alertcontext;
	}
	public Date getAlertdate() {
		return alertdate;
	}
	public void setAlertdate(Date alertdate) {
		this.alertdate = alertdate;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	
	

}
