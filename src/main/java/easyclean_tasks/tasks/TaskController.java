package easyclean_tasks.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskRepository taskRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public Tasks create(@RequestBody Tasks task){
		Tasks result = taskRepository.save(task);
		
		return result;
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value="/{TasksId}")
	public Tasks get(@PathVariable String TasksID){
		return taskRepository.findOne(TasksID);
	}
	
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object[] get(){
		return  taskRepository.findAll().toArray();
	}
}
