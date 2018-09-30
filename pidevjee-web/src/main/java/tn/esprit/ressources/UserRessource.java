package tn.esprit.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSSessionMode;
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

import tn.esprit.pidevjee.interfaces.InterfaceUserServiceRemote;
import tn.esprit.pidevjee.persistence.User;

@Path("users")
@RequestScoped
public class UserRessource {

	@EJB
	InterfaceUserServiceRemote usermetier;

//	@PUT
//	@Path("update")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void editUser(User user) {
//		usermetier.updateUser(user);
//		
//	}
	

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User u) {
		usermetier.updateUser(u);
		return Response.status(Status.OK).entity("User updated succesfully !").build();
	}
	
	

	@GET
	@Secured
	@Path("getusers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response.ok(usermetier.getAllUsers()).build();
	}

	@GET
	@Path("{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("email") String email, @PathParam("password") String password) {
		return Response.ok(usermetier.getUserByEmailAndPassword(email, password)).build();
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddUsers(User user) {
		usermetier.AjouterUser(user);
		return Response.status(Status.CREATED).build();
	}

}
