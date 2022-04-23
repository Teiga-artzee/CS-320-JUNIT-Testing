import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The TaskService Class will create a new Task, taking in the
 * 				   Parameters of the task name, and its description.
 * ----------------------------------------------------------------------------
 * 				   It will create a Unique ID for each task from the description.
 * ----------------------------------------------------------------------------
 * 				   The Tasks will be validated, making sure the data fits within
 *    			   The given parameters.
 * ----------------------------------------------------------------------------
 *  			   The Task List will check to make sure that this task doesn't 
 *   			   Exist before adding it into the list.
 */
public class TaskService {
	
	//Store all tasks
	Map<String, Task> taskList = new ConcurrentHashMap<String, Task>();
	
	//Constructor -- Not necessary, but good practice
	public TaskService() {}
	
	public TaskService(String taskName, String description)
	{
		//Create New Task
		Task tasks = null;
		Long id = hashID(Long.parseLong(description));
		tasks = new Task(taskName, description, id);
		
		//Verify correct info
		validateTasks(tasks);
		checkIfExists(tasks);
		
		//Add to list
		taskList.put(String.valueOf(id), tasks);
	}
	
	//UniqueID
	public Long hashID(Long key)
	{
		//Generates a unique ID number
		Long hashNum = 150L;
		key = key % hashNum;
		return key;
	}
	
	public Long hashID(Task tasks)
	{
		//Generates a unique ID number from phone number 
		//for verification uses from created contact
		int hashNum = 150;
		Long key = Long.parseLong(tasks.getDescription()) % hashNum;
		return key;
	}
	
	//Update
	public void updateTaskName(Task tasks, String newName) {tasks.setTaskName(newName);}
	public void updateDescription(Task tasks, String newDescription) {tasks.setDescription(newDescription);}
	
	//Delete
	public void deleteTask(Task task) {taskList.remove(task);}
	
	//Validate
	public void validateTasks(Task tasks)
	{
		tasks.validateTaskName();
		tasks.validateDescription();
	}
	
	//Check if Task is in list
	private void checkIfExists(Task tasks)
	{
		if(taskList.containsValue(tasks))
		{
			throw new RuntimeException("Contact Already Exists");
		}
	}
	
	//Check if contact doesn't exist
		public void checkIfDoesNotExist(Task task)
		{
			if(!taskList.containsValue(task))
			{
				throw new IllegalArgumentException("Task Does Not Exist");
			}
		}
	
	//Return full Task list
	public Collection<Task> getAllTasks()
	{
		return taskList.values();
	}

}
