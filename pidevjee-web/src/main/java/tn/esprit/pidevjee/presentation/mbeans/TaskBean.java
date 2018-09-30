package tn.esprit.pidevjee.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.pidevjee.persistence.Task;
import tn.esprit.pidevjee.persistence.User;
import tn.esprit.pidevjee.services.TaskService;

@ManagedBean
@SessionScoped

public class TaskBean  {
	
	private String name;
	private String description;
	private Date deadline;
	private String state; 
	private User Responsable ;
	private List<User> users ;
	private List <Task> tasks ; 
	private int taskIdToBeUpdated;
	private int selectedEmployeId;
	private List<Task> tasksSearch;
	private List<Task>tasksByID; 
	private List<Task>ab;
	private Task t;
	
	@EJB
	TaskService taskservice ; 

	
	@PostConstruct
	 public void init(){
		 
		 users =taskservice.getAllUsers();
		
	 }
	
	public void AddTask(){
		
     Task task = new Task(name,description,deadline);
	User seletedUser= new User();
	seletedUser.setId(selectedEmployeId);
	task.setUser(seletedUser);
	task.setState("En cours");
	taskservice.AddTask(task);
	
	}
	

	public List<Task> getAllTask(){
		  tasks = taskservice.getAllTasks();
		  System.out.println(tasks);
		   return tasks;
	   }
	


	public void deleteTask(int taskId){
		taskservice.deleteTask(taskId);
	}
	
	public void updateTask(Task task){
		this.setName(task.getName());
		this.setDescription(task.getDescription());
		this.setDeadline(task.getDeadline());
		this.setState(task.getState());
		this.setTaskIdToBeUpdated(task.getId());
		
	}
	public void mettreAjour1task(){
		
		taskservice.updateTask(new Task(taskIdToBeUpdated,name,description,deadline,state,Responsable));
		
	}
	
	public void validate(Task task){

		task.setState("validée");
		taskservice.updateTask(task);
		
	}
	
	public List<User> alertt(){
		
		 return taskservice.alert();
	}
	
	
	
	
	
	public List<Task> showTasksByName(String name, String description, Date deadline) {
 	 tasksSearch=taskservice.showTasksByName(name, description, deadline);
 	  return tasksSearch ;
	}
	
	
	

	public List<Task>GetTasksByID(){
		
		ab=taskservice.GetTasksByID();
		System.out.println(ab);
		return ab; 
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void setTaskIdToBeUpdated(Integer taskIdToBeUpdated) {
		this.taskIdToBeUpdated = taskIdToBeUpdated;
	}

	public Integer getSelectedEmployeId() {
		return selectedEmployeId;
	}

	public void setSelectedEmployeId(Integer selectedEmployeId) {
		this.selectedEmployeId = selectedEmployeId;
	}

	public List<Task> getTasksSearch() {
		return tasksSearch;
	}

	public void setTasksSearch(List<Task> tasksSearch) {
		this.tasksSearch = tasksSearch;
	}

	public void setSelectedEmployeId(int selectedEmployeId) {
		this.selectedEmployeId = selectedEmployeId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Task> getTaskByIdUser() {
		return tasksByID;
	}

	public void setTaskByIdUser(List<Task> taskByIdUser) {
		this.tasksByID = taskByIdUser;
	}
	
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public int getTaskIdToBeUpdated() {
		return taskIdToBeUpdated;
	}

	public void setTaskIdToBeUpdated(int taskIdToBeUpdated) {
		this.taskIdToBeUpdated = taskIdToBeUpdated;
	}
	
	

	public List<Task> getTasksByID() {
		return tasksByID;
	}

	public void setTasksByID(List<Task> tasksByID) {
		this.tasksByID = tasksByID;
	}

	public List<Task> getAb() {
		return ab;
	}

	public void setAb(List<Task> ab) {
		this.ab = ab;
	}

	public User getResponsable() {
		return Responsable;
	}

	public void setResponsable(User responsable) {
		Responsable = responsable;
	}
	
	
	
	
	
	
	
}
