/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The AppointmentTests Will Test the Appointment Class and
 *       		   Validate the functions in the Class
 * ----------------------------------------------------------------------------
 * 
 */
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	@Test
	void testAppointmentClass()
	{
		//Create date for app test
		Date date = new java.util.Date();
		
		//Verify
		AppointmentService service = new AppointmentService();
		Appointment appClass = new Appointment("My App", "This is my description under 50 char.", date, 12345L);
		assertTrue(appClass.getAppName(appClass).equals("My App"));
		assertTrue(appClass.getAppDescription(appClass).equals("This is my description under 50 char."));
		assertTrue(appClass.getDate(appClass).equals(date));
		assertEquals(appClass.getAppID(appClass), 12345L);
		service.validateAppointment(appClass);
	}
	
	//Too long tests
	@Test
	void testAppClassAppNameTooLong()
	{
		Date date = new java.util.Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("My App00000000001", "This is my description under 50 char.", date, 1234L);
		});
	}
	
	@Test
	void testAppClassDescriptionTooLong()
	{
		//Too Long Description
		Date date = new java.util.Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("My App", "This is my description well over 50 characters, It should throw an exception no problem.", date, 1234L);
		});
	}
	
	@Test
	void testAppClassIDTooLong()
	{
		//Too Long ID
		Date date = new java.util.Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("My App", "This is my description under 50 char.", date, 99999999999999999L);
		});
	}
	
	//Null Tests
	@Test
	void testAppClassAppNameNull()
	{
		//Test Name
		Date date = new java.util.Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, "This is my description under 50 char.", date, 1234L);
		});
	}
	
	@Test
	void testAppClassDescriptionNull()
	{
		//Test Description
		Date date = new java.util.Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("My App", null, date, 12345L);
		});
	}
	
	@Test
	void testAppDateNull()
	{
		//Test Date -- not Null
		//Date is null
		//FIX-ME
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("My App", "This is my description under 50 char.", null, 12345L);
		});
	}
	
	@Test
	void testAppDateCorrectDate()
	{
		//Test Date -- Not in past
		//Date is in past
		Date testDate = new Date(02-03-2022);		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Appointment("My App", "This is my description under 50 char.", testDate, 12345L);
		});
	}
	
	@Test
	void testAppClassIDNull()
	{
		//Test ID
		Date date = new java.util.Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("My App", "This is my description under 50 char.", date, -1L);
		});
	}
	
}

