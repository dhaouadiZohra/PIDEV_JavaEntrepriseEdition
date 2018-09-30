package tn.esprit.pidevjee.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.pidevjee.persistence.Comment;
import tn.esprit.pidevjee.persistence.Document;
import tn.esprit.pidevjee.persistence.User;
import tn.esprit.pidevjee.services.CommentService;
 
@ManagedBean
@SessionScoped
public class GrowlView {
	private String description;  
    private String message;
	private List<Comment> commentaires;
	private Date postDate;
	private int commentaireId;
	private Integer IDCommentToBeUpdate;
	@EJB
	CommentService commentService ;
	
	
	
   

	public List<Comment> getCommentaires() {
    	commentaires=commentService.getAllEmploye();
		return commentaires;
	}

	public void setCommentaires(List<Comment> commentaires) {
		this.commentaires = commentaires;
	}

	public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    
    
    public int getCommentaireId() {
		return commentaireId;
	}

	public void setCommentaireId(int commentaireId) {
		this.commentaireId = commentaireId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
    public void addComment()
	{
    	FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " +description ) );
		
        Comment com =new Comment(description);
	  
	    com.setPostdate(new Date());
	    Document documment=commentService.findDocumentbyid(1);
	    com.setDocumment(documment);
	    
	    User  user=commentService.findUserbyid(1);
	    com.setUtilisateur(user);
	    
		commentService.ajouterCommentaire(com);
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	
	public void suppEmp(int id){
		System.out.println("idempp"+id);
       
	commentService.supprimerCommentaire(id);
	     
	}
	

	
	
	public String Modifier(Comment c){
	    
		this.description=c.getDescription();
		this.IDCommentToBeUpdate=c.getId();
		String navigateTo="/Comment/newcomment?faces-redirect=true";
		return navigateTo;
	
}



//public String ModifCom(){
//    
//	commentService.updateComment(this.IDCommentToBeUpdate,this.description);
//	description="";
//String navigateTo="/Comment/newcomment?faces-redirect=true";
//return navigateTo;
//}

	

	public Integer getIDCommentToBeUpdate() {
		return IDCommentToBeUpdate;
	}

	public void setIDCommentToBeUpdate(Integer iDCommentToBeUpdate) {
		IDCommentToBeUpdate = iDCommentToBeUpdate;
	}
	
}