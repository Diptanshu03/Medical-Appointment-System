package com.SpringBoot.Medical_Appointment_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Medical_Appointment_System.Dto.Appointment;
import com.SpringBoot.Medical_Appointment_System.Service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	AppointmentService service;

	// create & add data
	@PostMapping("/appointments")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return service.createAppoinment(appointment);
	}

	// fetch by app id
	@GetMapping("/byid")
	public Appointment fetchByAppId(@RequestParam Long id) {
		return service.fetchByAppID(id);
	}

	// update doctor name & status by id
	@PutMapping("/appointments")
	public String updateDocNameStatus(@RequestParam long id, @RequestParam String newDocName, boolean newStatus) {
		int n = service.updateDocNameStatus(id, newDocName, newStatus);
		if (n == 0)
			return "Doctor name & Appointment status successfully Updated.";
		else
			return "Invalid Id Given.";
	}

	// delete appointment based on id
	@DeleteMapping("/appointments")
	public String deleteAppintment(@RequestParam long id) {
		int n = service.deleteAppointment(id);
		if (n == 0)
			return "Appintmnet Succefully Deleted.";
		else
			return "Invalid Id Given.";
	}

	// Delete appointments whose status is cancelled
	@DeleteMapping("/bystatus")
	public String deleteCancellStatus(@RequestParam boolean status) {
		int n = service.deleteCancellStatus(status);
		if (n != 0)
			return "Appintmnet Succefully Deleted.";
		else
			return "Error Occured";
	}

	// Retrieve appointments by doctor name.
	@GetMapping("/docbyname")
	public List<Appointment> fetchByDocName(@RequestParam String docName) {
		return service.fetchByDocName(docName);
	}

	// Find appointments on a specific date
	@GetMapping("/getbydate")
	public List<Appointment> getchByDate(@RequestParam String date) {
		return service.fetchByDate(date);
	}

	// display all appointments which are confirmed
	@GetMapping("/getbystatus")
	public List<Appointment> fetchByConfirmStatus(boolean status) {
		return service.fetchByConfirmStatus(status);
	}

	// update patient name and appointment date based on ID.
	@PutMapping("/updatebyid")
	public String updateNameDateById(@RequestParam long id, String newName, String newDate) {
		int n = service.updateNameDateById(id, newName, newDate);
		if (n == 0)
			return "Data Succefully Updated.";
		else
			return "Invalid Id Given";
	}

}
