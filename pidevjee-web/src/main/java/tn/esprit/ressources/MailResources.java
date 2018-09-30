package tn.esprit.ressources;



import java.util.Date;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.pidevjee.persistence.Mail;
import tn.esprit.pidevjee.persistence.User;
import tn.esprit.pidevjee.services.MailService;

@Path("mail")
@RequestScoped
public class MailResources {
	private String subject;
	private String context;
	private Date sentdate;
	private User receiver;
	private String receivermail;
	private User sender;
	@EJB
	MailService mailservice;
	
	
	@GET
	@Path("/sent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMailsent(){
		
		  return Response.ok(mailservice.getSent()).build();
		 
	 }
	@GET
	@Path("/received")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMailreceived(){
		
		  return Response.ok(mailservice.getReceived(4)).build();
		 
	 }
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMail(Mail m)
	{
	 sender=mailservice.getUserById(1);
	// receiver=mailservice.getUserById(int);
	 int x=mailservice.ajoutermail(m);
	 return Response.status(Status.CREATED).build();
		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public Response deleteUser(@PathParam("id") int id) {
	
		if(mailservice.supprimermail(id)){
			return Response.status(Status.OK).entity("Mail deleted").build();
		} 
			return Response.status(Status.NOT_ACCEPTABLE).entity("Mail not deleted").build();
				
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sent/{id}")
	public Response sentbyid(@PathParam("id") int id) {
	
		return Response.ok(mailservice.getMailById(id)).build();
				
	}
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{receivermail}")
	public Response getuserbymail(@PathParam("receivermail") String receivermail) {
	
		return Response.ok(mailservice.getUserByMail(receivermail)).build();
				
	}
	*/
	
	
	

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getSentdate() {
		return sentdate;
	}

	public void setSentdate(Date sentdate) {
		this.sentdate = sentdate;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getReceivermail() {
		return receivermail;
	}

	public void setReceivermail(String receivermail) {
		this.receivermail = receivermail;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}
	
}
