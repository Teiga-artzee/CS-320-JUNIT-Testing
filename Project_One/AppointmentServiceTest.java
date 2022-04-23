/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/03/2022
 * ----------------------------------------------------------------------------
 * Description   : The AppointmentService Test Will Validate The AppointmentService
 * 				   Class and its functions
 * ----------------------------------------------------------------------------
 * 				   
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	@Test
	void testAppointmentServiceClass()
	{
		//FIX-ME
		Date date = new java.util.Date();
		AppointmentService service = new AppointmentService("My App", "This is a description", date);
		Appointment app = new Appointment();
		service.checkIfExists(app);
		assertEquals(app.getAppName(app), "Bob");
	}
	
	//Make Sure It Can Not Add Same Appointment Twice
	@Test
	void testAppointmentServiceDoubleEntry()
	{
		Date date = new java.util.Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new AppointmentService("My App", "This is my description under 50 char.", date);
		});
		//Creating double should throw a problem
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new AppointmentService("My App", "This is my description under 50 char.", date);
		});
	}
	
	//Test NAME
	@Test
	void testAppointmentServiceValidateNameTooLong()
	{
		Date date = new java.util.Date();
		AppointmentService app = new AppointmentService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment service = new Appointment("My App Name is Too Long", "This is my description under 50 char.", date, 123345L);
			app.validateAppointment(service);
		});
	}
	
	@Test
	void testAppointmentServiceValidateNameNull()
	{
		Date date = new java.util.Date();
		AppointmentService app = new AppointmentService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment service = new Appointment(null, "This is my description under 50 char.", date, 123345L);
			app.validateAppointment(service);
		});
	}
	
	//Test DESCRIPTION
	@Test
	void testAppointmentServiceValidateDescriptionTooLong()
	{
		Date date = new java.util.Date();
		AppointmentService app = new AppointmentService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment service = new Appointment("My App", "This is my description not under 50 characters, I will write a very long description to throw an error and test the code.", date, 123345L);
			app.validateAppointment(service);
		});
	}
	
	@Test
	void testAppointmentServiceValidateDescriptionNull()
	{
		Date date = new java.util.Date();
		AppointmentService app = new AppointmentService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment service = new Appointment("My App", null, date, 123345L);
			app.validateAppointment(service);
		});
	}
	
	//Test DATE
	@Test
	void testAppointmentServiceValidateDateInPast()
	{
		Date testDate = new Date(02-03-2022);
		AppointmentService app = new AppointmentService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment service = new Appointment("My App", "This is my description under 50 char.", testDate, 123345L);
			app.validateAppointment(service);
		});
	}
	
	@Test
	void testAppointmentServiceValidateDateNull()
	{
		Date testDate = null;
		AppointmentService app = new AppointmentService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment service = new Appointment("My App", "This is my description under 50 char.", testDate, 123345L);
			app.validateAppointment(service);
		});
	}
	
	//Test ID
	@Test
	void testAppointmentServiceValidateIDTooLong()
	{
		Date date = new java.util.Date();
		AppointmentService app = new AppointmentService();
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment service = new Appointment("My App", "This is my description under 50 char.", date, 99999999999999999L);
			app.validateAppointment(service);
		});
	}
	
	@Test
	void testAppointmentServiceValidateIDNull()
	{
		Date date = new java.util.Date();
		AppointmentService app = new AppointmentService();
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment service = new Appointment("My App", "This is my description under 50 char.", date, -1L);
			app.validateAppointment(service);
		});
	}

	//Test DELETE -- Make sure it removes Task
	@Test
	void testDeleteAppointmentTest()
	{
		Date date = new java.util.Date();
		AppointmentService service = new AppointmentService();
		Appointment app = new Appointment("My App", "This is my description under 50 char.", date, 1234L);
		service.deleteAppointment(app);
				
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.checkIfDoesNotExist(app);
		});
	}
}
