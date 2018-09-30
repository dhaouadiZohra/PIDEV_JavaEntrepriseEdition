package tn.esprit.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import tn.esprit.pidevjee.services.DocumentService;

@Path("documents")
@RequestScoped
public class DocumentRessource {
@EJB
DocumentService documentmetier;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocuments(){
		return Response.ok(documentmetier.getAllDocs()).build();
	}
	
	
	@DELETE
	@Path("/{id}")  
	public Response deleteDocByid(@PathParam("id") int id){  
		if((boolean) documentmetier.deleteDocumentById(id)){
			return Response.status(Status.OK).entity("document deleted").build();
		}
			return Response.status(Status.NOT_ACCEPTABLE).entity("document NOT deleted").build();
		

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getDocById(@PathParam("id") int id)
	{
		return Response.ok(documentmetier.getDocById(id)).build();
	}
	
	
	
	
	
	

}
