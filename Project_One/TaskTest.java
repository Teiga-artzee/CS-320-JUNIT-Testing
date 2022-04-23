/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The Task Testing will test the Task Class.
 * ----------------------------------------------------------------------------
 * 				   
 * ----------------------------------------------------------------------------
 * 
 */
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testTaskClass()
	{
		Task taskClass = new Task("My Task", "This is my description under 50 char.", 1234L);
		assertTrue(taskClass.getTaskName().equals("My Task"));
		assertTrue(taskClass.getDescription().equals("This is my description under 50 char."));
		assertEquals(taskClass.getID(), 1234);
		
		
		
	}
	
	//Too long tests
	@Test
	void testTaskClassTaskNameTooLong()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Sarah 0000000", "This is my description under 50 char.", 1234L);
		});
	}
	
	@Test
	void testTaskClassDescriptionTooLong()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("My Task", "This is my description well over 50 characters, It should throw an exception no problem.", 1234L);
		});
	}
	
	@Test
	void testTaskClassIDTooLong()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("My Task", "This is my description under 50 char.", 99999999999999999L);
		});
	}
	
	//Null Tests
	@Test
	void testTaskClassTaskNameNull()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "This is my description under 50 char.", 1234L);
		});
	}
	
	@Test
	void testTaskClassDescriptionNull()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("My Task", null, 1234L);
		});
	}
	
	@Test
	void testTaskClassIDNull()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("My Task", "This is my description under 50 char.", -1L);
		});
	}

}
