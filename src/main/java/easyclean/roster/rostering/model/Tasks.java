package easyclean.roster.rostering.model;

public class Tasks {
 private int id; 
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTaskName() {
	return taskName;
}
public void setTaskName(String taskName) {
	this.taskName = taskName;
}
public String getTaskDescription() {
	return taskDescription;
}
public void setTaskDescription(String taskDescription) {
	this.taskDescription = taskDescription;
}
private String taskName;
 private String taskDescription;
}
