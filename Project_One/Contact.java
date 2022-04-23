/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The Contact class creates the contact object, validating
 * 				   if the information is entered correctly.
 * ----------------------------------------------------------------------------
 *  			   Further exception handling could be used, when integrating
 *  			   UI, to allow the user a chance to reenter the information
 *  			   Correctly when an exception is found, instead of ending a
 *  			   Program as it would currently.
 */
public class Contact {
	
	private String firstName = null;
	private String lastName =  null;
	private String number =  null;
	private String address = null;
	private int id =  -1;
	
	//Constructor -- Not necessary, but good practice
	public Contact() {}
	
	public Contact(String firstName, String lastName, String number, String address, int id)
	{
		
		//Checks
		if (firstName == null || firstName.length() > 10)
		{
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length() > 10)
		{
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (number == null || number.length() != 10)
		{
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if (address == null || address.length() > 30)
		{
			throw new IllegalArgumentException("Invalid Address");
		}
		if (id == -1 || String.valueOf(id).length() > 10)
		{
			throw new IllegalArgumentException("Invalid ID");
		}
		
		//Setters
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
		this.id = id;
		
	}
	//Getters
	public String getFirstName(Contact contact) {return contact.firstName;}
	public String getLastName(Contact contact) {return contact.lastName;}
	public String getNumber(Contact contact) {return contact.number;}
	public String getAddress(Contact contact) {return contact.address;}
	public int getID(Contact contact) {return contact.id;}
	
	//Setters
	public void setFirstName(String newName){this.firstName = newName;}
	public void setLastName(String newName) {this.lastName = newName;}
	public void setNumber(String number) {this.number = number;}
	public void setAddress(String address) {this.address = address;}
	
	//Validate
	public void validateFirstName()
	{
		if (this.firstName.isBlank())
		{
			throw new RuntimeException("Invalid First Name");
		}
	}
	public void validateLastName()
	{
		if (this.lastName.isBlank())
		{
			throw new RuntimeException("Invalid Last Name");
		}
	}
	public void validateAddress()
	{
		if (this.address.isBlank())
		{
			throw new RuntimeException("Invalid Address");
		}
	}
	public void validatePhoneNumber()
	{
		if (this.number.isBlank() && this.number.length() != 10)
		{
			throw new RuntimeException("Invalid Phone Number");
		}
	}
	
}
