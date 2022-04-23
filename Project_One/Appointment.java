/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The Appointment Class object will take in a date, description field
 * 				   and Name field, plus a unique ID 
 * ----------------------------------------------------------------------------
 * 				   Each field of the class object Appointment is validated
 * 				   To make sure it has followed the restrictions of the
 * 				   Application
 * ----------------------------------------------------------------------------
 * 
 */

import java.util.Date;

public class Appointment {

	private String description = null;
	private String name = null;
	private long id = -1L;
	
	private Date dateObject = null;
	
	//Constructor -- Not necessary, but good practice
	public Appointment() {}
	
	public Appointment(String name, String description, Date dateObject, long id) 
	{
		//Checks
		if (name == null || name.length() > 10)
		{
			throw new IllegalArgumentException("Invalid Appointment Name");
		}
		if (description == null || description.length() > 50)
		{
			throw new IllegalArgumentException("Invalid Description");
		}
		if (dateObject.before(new Date()))
		{
			throw new IllegalArgumentException("Invalid Date");
		}
		if (dateObject == null)
		{
			throw new IllegalArgumentException("Invalid Date");
		}
		if (id == -1 || String.valueOf(id).length() > 10)
		{
			throw new IllegalArgumentException("Invalid ID");
		}
		
		//Create appointment
		this.name = name;
		this.description = description;
		this.dateObject = dateObject;
		this.id = id;
	}
	
	//Setters
	public void setAppName(Appointment app, String name) {app.name = name;}
	public void setAppDescription(Appointment app, String description) {app.description = description;}
	public void setAppDate(Appointment app, Date date) {app.dateObject = date;}
	
	//Getters
	public String getAppName(Appointment app) {return app.name;}
	public String getAppDescription(Appointment app) {return app.description;}
	public Date getDate(Appointment app) {return app.dateObject;}
	public Long getAppID(Appointment app) {return app.id;}
	
	//Validate
	public void validateAppName(Appointment app)
	{
		if (app.name == null || app.name.length() >10)
		{
			throw new RuntimeException("Invalid Appointment Name");
		}
	}
	public void validateAppDescription(Appointment app)
	{
		if (app.description == null || app.description.length() > 10)
		{
			throw new RuntimeException("Invalid Description");
		}
	}
	public void validateDate(Appointment app)
	{
		
		if (app.dateObject.before(new Date()) || this.dateObject == null)
		{
			throw new RuntimeException("Invalid Date");
		}
	}
	public void validateID(Appointment app)
	{
		String tempID = Long.toString(id);
		if (app.id == -1 && tempID.length() >= 10)
		{
			throw new RuntimeException("Invalid ID");
		}
	}
}
