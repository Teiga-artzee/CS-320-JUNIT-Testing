/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The Contact Class Test will test the Contact Class.
 * ----------------------------------------------------------------------------
 * 				   The main function of creating a contact object is first verified
 * 				   with correct information, to determine it works when there are
 * 				   No issues.
 * ----------------------------------------------------------------------------
 * 				   The restraints of the program attributes are then tested to
 * 				   Ensure that the exceptions are handled appropriately, and do
 * 				   Not create an object that goes against the requirements.
 * ----------------------------------------------------------------------------
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import junit.framework.*;


class ContactTest{

	@Test
	void testContactClass()
	{
		Contact contactClass = new Contact("Mary", "Sue", "3193497272", "68 Augustine ct", 123456789);
		assertTrue(contactClass.getFirstName(contactClass).equals("Mary"));
		assertTrue(contactClass.getLastName(contactClass).equals("Sue"));
		assertTrue(contactClass.getNumber(contactClass).equals("3193497272"));
		assertTrue(contactClass.getAddress(contactClass).equals("68 Augustine ct"));
		assertEquals(contactClass.getID(contactClass), 123456789);
	}
	
	//Too long tests
	@Test
	void testContactClassFirstNameTooLong()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah 0000000", "Sue", "3193497272", "68 Augustine ct", 123456789);
		});
	}
	
	@Test
	void testContactClassLastNameTooLong()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah", "Sue 0000000", "3193497272", "68 Augustine ct", 123456789);
		});
	}
	
	@Test
	void testContactClassNumberTooLong()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah", "Sue", "3193497272 0000", "68 Augustine ct", 123456789);
		});
	}
	
	@Test
	void testContactClassAddressTooLong()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah", "Sue", "3193497272", "68 Augustine ct 0000000000000000000", 123456789);
		});
	}
	
	@Test
	void testContactClassIDTooLong()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah", "Sue", "3193497272", "68 Augustine ct", 00001000100);
		});
	}
	
	//Null Tests
	@Test
	void testContactClassFirstNameNull()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Sue", "3193497272", "68 Augustine ct", 123456789);
		});
	}
	
	@Test
	void testContactClassLastNameNull()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah", null, "3193497272", "68 Augustine ct", 123456789);
		});
	}
	
	@Test
	void testContactClassNumberNull()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah", "Sue", null, "68 Augustine ct", 123456789);
		});
	}
	
	@Test
	void testContactClassAddressNull()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah", "Sue", "3193497272", null, 123456789);
		});
	}
	
	@Test
	void testContactClassIDNull()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Sarah", "Sue", "3193497272", "68 Augustine ct", -1);
		});
	}

}
