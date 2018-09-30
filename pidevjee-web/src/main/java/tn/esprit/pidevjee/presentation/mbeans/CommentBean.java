package tn.esprit.pidevjee.presentation.mbeans;

import java.sql.Timestamp;



import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.pidevjee.interfaces.CommentServiceLocal;
import tn.esprit.pidevjee.persistence.Comment;
import tn.esprit.pidevjee.persistence.Document;
import tn.esprit.pidevjee.services.CommentService;
import tn.esprit.pidevjee.services.DocumentService;
import tn.esprit.pidevjee.persistence.User;



@ManagedBean
@SessionScoped
public class CommentBean {

	@EJB
	CommentService commentService ;
	
    
	private int idComment;
	private String description; 
	private int idUser;
	private int idDocument;
	private Date postDate;
	private int commentaireId;
	

	private List<Comment> commentaires;


	public List<Comment> getCommentaires() {
		commentaires = commentService.getAllEmploye();
		return commentaires;
	}
     
	
	

	public void setCommentaires(List<Comment> commentaires) {
		this.commentaires = commentaires;
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

  

	public void addComment()
	{
		Comment com=new Comment(description);
	  
	    com.setPostdate(new Date());
	    Document documment=commentService.findDocumentbyid(1);
	    com.setDocumment(documment);
	    
	    User  user=commentService.findUserbyid(3);
	    com.setUtilisateur(user);
	    
		commentService.ajouterCommentaire(com);
	}
	

	public String Modifier(Comment c){
	    
		this.description=c.getDescription();
		this.idComment=c.getId();
		String navigateTo="/Comment/newcomment?faces-redirect=true";
		return navigateTo;
	
}



//public String ModifCom(){
//    
//	commentService.updateComment(this.idComment,this.description);
//	description="";
//String navigateTo="/Comment/newcomment?faces-redirect=true";
//return navigateTo;
//}



	
	
	

	public int getIdComment() {
	return idComment;
}




public void setIdComment(int idComment) {
	this.idComment = idComment;
}




	public Date getPostDate() {
		return postDate;
	}




	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}




	public int getCommentaireId() {
		return commentaireId;
	}




	public void setCommentaireId(int commentaireId) {
		this.commentaireId = commentaireId;
	}







	


	
    
}
