/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The ContactService Testing will test the Contact Service Class
 * ----------------------------------------------------------------------------
 * 				   The attributes within the class will be tested against the
 * 				   Program restraints, and verify that exceptions are caught.
 * ----------------------------------------------------------------------------
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import junit.framework.*;

class ContactServiceTest {

	@Test
	//Validate all correct attributes can create object
	void validateContactServiceTest()
	{
		ContactService service = new ContactService();
		Contact contact = new Contact("Mary", "Sue", "1111111111", "Address", 1234);
		service.validateContact(contact);
		
		assertTrue(contact.getFirstName(contact).equals("Mary"));
		assertTrue(contact.getLastName(contact).equals("Sue"));
		assertEquals(contact.getID(contact), 1234);
	}
	
	@Test
	void testContactServiceClass()
	{
		ContactService service = new ContactService("Mary", "Sue", 1111111111, "68 Augustine st");
		Contact contact = new Contact();
		service.changeFirstName(contact, "Bob");
		assertEquals(contact.getFirstName(contact), "Bob");
	}
	
	//Make Sure It Can Not Add Same Contact Twice
	@Test
	void testAppointmentServiceDoubleEntry()
	{
		Assertions.assertThrows(RuntimeException.class, () -> {
			new ContactService("Mary","Sue", 1111111111, "68 Augustine st");
		});
		//Creating double should throw a problem
		Assertions.assertThrows(RuntimeException.class, () -> {
			new ContactService("Mary","Sue", 1111111111, "68 Augustine st");
		});
	}
	
	//Test FIRST NAME
	@Test
	void testContactServiceValidateFirstNameTooLong()
	{
		
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("Mary 000000", "Sue", "1111111111", "68 Augustine st", 12345);
			service.validateContact(contact);
		});
	}
	
	@Test
	void testContactServiceValidateFirstNameNull()
	{
		
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(null, "Sue", "1111111111", "68 Augustine st", 12345);
			service.validateContact(contact);
		});
	}
	
	//Test LAST NAME
		@Test
		void testContactServiceValidateLastNameTooLong()
		{
			
			ContactService service = new ContactService();
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				Contact contact = new Contact("Mary", "Sue 0000000000", "1111111111", "68 Augustine st", 12345);
				service.validateContact(contact);
			});
		}
		
		@Test
		void testContactServiceValidateLastNameNull()
		{
			
			ContactService service = new ContactService();
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				Contact contact = new Contact("Mary", null, "1111111111", "68 Augustine st", 12345);
				service.validateContact(contact);
			});
		}
	
	//Test ADDRESS
	@Test
	void tesContactServiceValidateAddressNull()
	{
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("Mary", null, "1111111111", null, 12345);
			service.validateContact(contact);
		});
	}
	
	//Test Phone Number
	@Test
	void testContactServiceValidatePhoneNumberTooLong()
	{
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("Mary", "Sue", "111111111111111111111", "68 Augustine st", 12345);
			service.validateContact(contact);
		});
	}
	
	@Test
	void testContactServiceValidatePhoneNumberNull()
	{
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("Mary", "Sue", null, "68 Augustine st", 12345);
			service.validateContact(contact);
		});
	}
	
	//Test ID
	@Test
	void testContactServiceValidateIDTooLong()
	{
		ContactService service = new ContactService();
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("Mary", "Sue", "1111111111", "68 Augustine st", 00001000100);
			service.validateContact(contact);
		});
	}
	
	@Test
	void testContactServiceValidateIDNull()
	{
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("Mary", "Sue", "1111111111", "68 Augustine st", -1);
			service.validateContact(contact);
		});
	}
	
	//Test DELETE -- Make sure it removes contact
	@Test
	void testDeleteContactTest()
	{
		ContactService service = new ContactService();
		Contact contact = new Contact("Mary", "Sue", "1111111111", "68 Augustine st", 1234);
		service.deleteContact(contact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.checkIfDoesNotExist(contact);
		});
	}

}
