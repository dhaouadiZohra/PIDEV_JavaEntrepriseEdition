package tn.esprit.pidevjee.presentation.mbeans;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.pidevjee.persistence.Role;
import tn.esprit.pidevjee.persistence.Sexe;
import tn.esprit.pidevjee.persistence.Task;
import tn.esprit.pidevjee.persistence.User;
import tn.esprit.pidevjee.services.UserService;
@ManagedBean
@SessionScoped
public class UserBean {
	
	private String lastname;
	private String firstname;
	
	private String email;
	private String cin;
	private Role role;
	private String password;
	private Sexe sexe;
	private int age;
	private float salaire;
	private Boolean isValid;
	private List<User> users;
	
	private Integer userIDToBeUpdated;
	@EJB
	UserService userservice;
	
	@ManagedProperty(value="#{loginBean}")
	LoginBean loginBean;
	 public String adduser(){
		if(loginBean ==null || loginBean.getLoggedIn()==null){
			 return "/pages/admin/notConnected?faces-redirect=true";
			 
		 }
		 else{ 
			 if(loginBean != null ||loginBean.getLoggedIn()==true){
		 userservice.AjouterUser( new User(lastname,firstname,email,cin,role,password,sexe,age,salaire,isValid));
			 }}
	    return null;
		 }
	   
	   public List<User> getUsers(){
		   users = userservice.getAllUsers();
		   return users;
	   }
	
	
	   
	   public String DeleteUser(Integer UserID){
			if(loginBean ==null || loginBean.getLoggedIn()==null){
				 return "/pages/admin/notConnected?faces-redirect=true";
				 
			 }
			 else{ 
				 if(loginBean != null ||loginBean.getLoggedIn()==true){
		   userservice.UserDeleteByID(UserID);
	   }}
			return null;
	   }
	   
	   public void modifier(User user){
		   this.setEmail(user.getEmail());
		   this.setPassword(user.getPassword());
		   this.setLastname(user.getLastname());
		   this.setFirstname(user.getFirstname());
		   this.setSalaire(user.getSalaire());
		   this.setAge(user.getAge());
		   this.setRole(user.getRole());
		   this.setIsValid(user.IsValid());
		   this.setUserIDToBeUpdated(user.getId());
		   
	   }
	public String  mettreAjourUser(){
		if(loginBean ==null || loginBean.getLoggedIn()==null){
			 return "/pages/admin/notConnected?faces-redirect=true";
			 
		 }else{
			 if(loginBean != null ||loginBean.getLoggedIn()==true){
		userservice.updateUser(new User(lastname,firstname,email,cin,password,isValid,role,sexe,age,salaire,userIDToBeUpdated));
	}}
	return null;
}
public void doSaveOrUpdate(){
	
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
		
		userservice.updateUser(loginBean.getUser());
	
isValid =false;
		
	}



	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}

	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Sexe getSexe() {
		return sexe;
	}



	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	
	
	
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Integer getUserIDToBeUpdated() {
		return userIDToBeUpdated;
	}
	public void setUserIDToBeUpdated(Integer userIDToBeUpdated) {
		this.userIDToBeUpdated = userIDToBeUpdated;
	}
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
