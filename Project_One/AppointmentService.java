import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * 
 * Author        : Alexandrea Teigeler
 * Last Edit Date: 04/06/2022
 * ----------------------------------------------------------------------------
 * Description   : The AppointmentService Class Will be able to add an
 * 				   Appointment, creating a unique ID key. 
 * ----------------------------------------------------------------------------
 * 				   Appointments can be deleted per ID
 * ----------------------------------------------------------------------------
 * 
 */
public class AppointmentService {

	//Stores all Appointments
	Map<String, Appointment> appointmentList = new ConcurrentHashMap<String, Appointment>();
	
	//Creates Date object
	//private Date dateObject = new Date(); //Is this needed?
	//Constructor -- Not necessary, but good practice
	public AppointmentService() {}
	
	public AppointmentService(String name, String description, Date date) 
	{
		//Create Key
		Long id = hashID(name, date);
		
		//Creates a new app
		Appointment app = null;
		
		//Make sure all if appointment doesn't already exist
		app = new Appointment(name, description, date, id);
		validateAppointment(app);
		checkIfExists(app);
				
		//Adds appointments to list
		appointmentList.put(String.valueOf(id), app);
		
	}
	
	//Create Key
	public Long hashID(String name, Date date)
	{
		//Generates a unique ID number from Name and Date
		Long tempName = Long.parseLong(name);
		Long tempDate = Long.parseLong(date.toString());
		
		int hashNum = 150;
		Long key = (tempName + tempDate) % hashNum;
		return key;
	}
	
	//Validate Key
	public Long hashID(Appointment app)
	{
		//Generates a unique ID number from Name and Date
		Long tempName = Long.parseLong(app.getAppName(app));
		Long tempDate = Long.parseLong(app.getDate(app).toString());
		
		int hashNum = 150;
		Long key = (tempName + tempDate) % hashNum;
		return key;
	}
	
	//Validate
	public void validateAppointment(Appointment app)
	{
		app.validateAppName(app);
		app.validateAppDescription(app);
		app.validateDate(app);
		app.validateID(app);
	}
	
	//Return full contact list
	public Collection<Appointment> getAllAppointments()
	{
		return appointmentList.values();
	}
	
	public void deleteAppointment(Appointment app) {appointmentList.remove(app);}
	
	//Check if contact in list
	public void checkIfExists(Appointment app)
	{
		if(appointmentList.containsValue(app))
		{
			throw new RuntimeException("App Already Exists");
		}
		}
		
	//Check if Appointment doesn't exist
	public void checkIfDoesNotExist(Appointment app)
	{
		if(!appointmentList.containsValue(app))
		{
			throw new IllegalArgumentException("Appointment Does Not Exist");
		}
	}
	
}
