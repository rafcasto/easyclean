package easyclean.timesheets.times;

public class Tasks {
 private String id; 
 public String getId() {
	return id;
}
public void setId(String id) {
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
