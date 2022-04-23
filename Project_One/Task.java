/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The Task Class takes in the parameters of the task name, 
 * 				   Description, and id created from the taskService. 
 * 				   These values are validated, and if they do not fail, then 
 * 				   The object is created.
 * ----------------------------------------------------------------------------
 * 				   The Getters are used to return the specifics object value of
 * 				   That attribute, while the setters are used to assign the
 * 				   Attributes a different value.
 * ----------------------------------------------------------------------------
 * 				   The Validation is used with the TaskService Class and Testing
 *  			   To ensure that the values of the attributes are correct.
 * ----------------------------------------------------------------------------
 * 
 */
public class Task {
	
	//Task object shall have a required unique task ID string that cannot be longer than 10 numbers--CANNOT be null, or updateable
	
	//Task object shall have a required name string field that can not be longer than 10 char. Shall not be null
	
	//Task object shall have a required description filed that cannot be longer than 50 char. SHall not be null
	
	private String taskName = null;
	private String description = null;
	private Long id = -1L;
	
	//Constructor -- Not necessary, but good practice
	public Task() {}
	
	public Task(String taskName, String description, Long id)
	{
		//Checks
		if (taskName == null || taskName.length() > 10)
		{
		throw new IllegalArgumentException("Invalid Task Name");
		}
		if (description == null || description.length() > 50)
		{
		throw new IllegalArgumentException("Invalid description");
		}
		if (id == -1 || String.valueOf(id).length() > 10)
		{
		throw new IllegalArgumentException("Invalid ID");
		}
				
		//Setters
		this.taskName = taskName;
		this.description = description;
		this.id = id;		
	}
	
	//Getters
	public String getTaskName() {return this.taskName;}
	public String getDescription() {return this.description;}
	public Long getID() {return this.id;}
	
	//Setters
	public void setTaskName(String newName) {this.taskName = newName;}
	public void setDescription(String newDescription) {this.description = newDescription;}
	
	//Validate
	public void validateTaskName()
	{
		if (this.taskName.isBlank() && this.taskName.length() > 10)
		{
			throw new RuntimeException("Invalid Task Name");
		}
	}
	public void validateDescription()
	{
		if (this.description.isBlank() && this.description.length() > 50)
		{
			throw new RuntimeException("Invalid description");
		}
	}
}
