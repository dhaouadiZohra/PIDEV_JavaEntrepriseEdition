package tn.esprit.ressources;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.pidevjee.interfaces.InterfaceTaskServiceRemote;
import tn.esprit.pidevjee.persistence.Task;

@Path("tasks")
@RequestScoped
public class TaskRessource {


	@EJB
	InterfaceTaskServiceRemote taskmetier;
	
	
	/*affichage des taches */ 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
      public Response getAllTasks(){
	
	    return Response.ok(taskmetier.getAllTasks()).build();
}
	
	/*Ajout */ 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTask(Task t)
	{

	 taskmetier.AddTask(t);
	 return Response.status(Status.CREATED).entity("task added").build();
		
	}
	
	
	
	/*delete*/ 
	
	@DELETE

	@Path("{id}")
	public Response deleteTask(@PathParam("id") int id) {
	
		if(taskmetier.deleteTask(id)=="true")
		{
			return Response.status(Status.OK).entity("Task deleted").build();
		} 
			return Response.status(Status.NOT_ACCEPTABLE).entity("Task not deleted").build();
				
	}
	
	
	
	/*affichage des users */ 
	@GET
	@Path("{c}")
	@Produces(MediaType.APPLICATION_JSON)
      public Response getAllUsers(){
	
	    return Response.ok(taskmetier.getAllUsers()).build();
}
	
	
	
	@PUT
	@Path("{idtask}/{iduser}")
	
	@Produces(MediaType.TEXT_PLAIN)
	public Response affectertask(@PathParam("idtask") int idtask,
			@PathParam("iduser") int iduser){
		
	
		if(taskmetier.affectertasktouser(idtask, iduser))
		
		{return Response.ok().entity("this task is affected").build();}
		
		
		return Response.status(Status.FORBIDDEN).entity("this task is not found").build();
		
	}
	
	
	
	
	
}
