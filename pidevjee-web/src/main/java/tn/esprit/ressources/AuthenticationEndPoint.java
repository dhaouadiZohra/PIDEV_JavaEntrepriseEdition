package tn.esprit.ressources;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import tn.esprit.pidevjee.persistence.User;

@Path("authentication")
@Transactional
public class AuthenticationEndPoint {

	// ======================================
	// = Injection Points =
	// ======================================

	@Context
	private UriInfo uriInfo;

	@PersistenceContext
	private EntityManager em;
	
	@Context
	SecurityContext securityContext;

	@POST
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticateUser(User credentials) {

	    String username = credentials.getEmail();
	    String password = credentials.getPassword();

		try {
			
			// Authenticate the user using the credentials provided
			authenticate(username, password);

			// Issue a token for the user
			String token = issueToken(username);

			// Return the token on the response
			return Response.ok(token).build();

		} catch (Exception e) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}

	private void authenticate(String username, String password) {
		// Authenticate against a database, LDAP, file or whatever
		// Throw an Exception if the credentials are invalid
		System.out.println("Authenticating user...");
	
	}

	private String issueToken(String username) {
    	Random random = new SecureRandom();
    	String token = new BigInteger(130, random).toString(32);
    	return "Bearer "+ token ;
			}

			// ======================================
			// = Private methods =
			// ======================================

			private Date toDate(LocalDateTime localDateTime) {
				return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
			}

		}

