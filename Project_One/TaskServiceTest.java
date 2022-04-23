/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The TaskService Testing will test the TaskService Class.
 * ----------------------------------------------------------------------------
 * 				   
 * ----------------------------------------------------------------------------
 * 
 */
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	@Test
	void validateTaskServiceTest()
	{
		TaskService service = new TaskService();
		Task task = new Task("My Task", "My description under 50 char.", 1234L);
		service.validateTasks(task);
		
		assertTrue(task.getTaskName().equals("My Task"));
		assertTrue(task.getDescription().equals("My description under 50 char."));
		assertTrue(task.getID().equals(1234L));
	}
	
	@Test
	//Make Sure It Can Not Add Same Task Twice
	void testTaskServiceDoubleEntry()
	{
		Assertions.assertThrows(RuntimeException.class, () -> {
			new TaskService("Mary","My Description under 50 char.");
		});
		//Creating double should throw a problem
		Assertions.assertThrows(RuntimeException.class, () -> {
			new TaskService("Mary","My Description under 50 char.");
		});
	}
	
	//Test TASK NAME
	@Test
	void testTaskServiceValidateTaskNameTooLong()
	{
		
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("My Task Name Is Too Long", "My description under 50 char.", 1234L);
			service.validateTasks(task);
		});
	}
	
	@Test
	void testTaskServiceValidateTaskNameNull()
	{
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task(null, "My description under 50 char.", 1234L);
			service.validateTasks(task);
		});
	}
	
	//Test DESCRIPTION
	@Test
	void testTaskServiceValidateDescriptionTooLong()
	{	
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("My Task", "My description over 50 characters, this should throw an exception, so we will test it.", 1234L);
			service.validateTasks(task);
			});
	}
		
	@Test
	void testTaskServiceValidateDescriptionNull()
	{
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("My Task", null, 1234L);
			service.validateTasks(task);
		});		
			
	}
	
	//Test ID
	@Test
	void testContactServiceValidateIDTooLong()
	{
		TaskService service = new TaskService();
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("My Task", "My Description under 50 char.", 00001000100L);
			service.validateTasks(task);
		});
	}
	
	@Test
	void testContactServiceValidateIDNull()
	{
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("My Task", "My Description under 50 char.", -1L);
			service.validateTasks(task);
		});
	}
	
	//Test DELETE -- Make sure it removes Task
		@Test
		void testDeleteTaskTest()
		{
			TaskService service = new TaskService();
			Task task = new Task("My Task", "My Description under 50 char.", 1234L);
			service.deleteTask(task);
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				service.checkIfDoesNotExist(task);
			});
		}

}
