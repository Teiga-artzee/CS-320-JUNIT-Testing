/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The Contact Service will add contacts to the system with a
 * 				   Unique ID that is generated using a HASH formula from the
 * 				   Phone number as these are unique to each contact.
 * ----------------------------------------------------------------------------
 * 				   The Contact information, such as the first name, last name
 * 				   phone number, and address can be altered, the ID can not.
 * ----------------------------------------------------------------------------
 * 				   The Contact can also be deleted
 * ----------------------------------------------------------------------------
 * 		`		   Further exception handling could be used, when integrating
 *  			   UI, to allow the user a chance to reenter the information
 *  			   Correctly when an exception is found, instead of ending a
 *  			   Program as it would currently.
 */

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactService {

	//Stores all contacts
	Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();
	
	//Constructor -- Not necessary, but good practice
	public ContactService() {}
	
	public ContactService(String firstName, String lastName, int number, String address)
	{
		//Creates a new Contact
		Contact contacts = null;
		int id = hashID(number);
		contacts = new Contact(firstName, lastName, String.valueOf(number), address, id);
		
		//Validate
		validateContact(contacts);
		checkIfExists(contacts);
		
		//Adds contact to list
		contactList.put(String.valueOf(id), contacts);
	}
	
	public int hashID(int key)
	{
		//Generates a unique ID number from phone number
		int hashNum = 150;
		key = key % hashNum;
		return key;
	}
	
	//Updates Contact info
	public void changeFirstName(Contact contact, String newName) {contact.setFirstName(newName);}
	public void changeLastName(Contact contact, String newName) {contact.setFirstName(newName);}
	public void changeNumber(Contact contact, String number) {contact.setFirstName(number);}
	public void changeAddress(Contact contact, String address) {contact.setFirstName(address);}
	
	//Delete Contact
	public void deleteContact(Contact contact) {contactList.remove(contact);}
	
	//Validate
	public void validateContact(Contact contact)
	{
		contact.validateFirstName();
		contact.validateLastName();
		contact.validateAddress();
		contact.validatePhoneNumber();
	}
	
	//Check if contact in list
	public void checkIfExists(Contact contact)
	{
		if(contactList.containsValue(contact))
		{
			throw new RuntimeException("Contact Already Exists");
		}
	}
	
	//Check if contact doesn't exist
	public void checkIfDoesNotExist(Contact contact)
	{
		if(!contactList.containsValue(contact))
		{
			throw new IllegalArgumentException("Contact Does Not Exist");
		}
	}
	
	//Return full contact list
	public Collection<Contact> getAllContacts()
	{
		return contactList.values();
	}
}
