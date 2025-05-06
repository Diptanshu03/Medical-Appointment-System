package com.SpringBoot.Medical_Appointment_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Medical_Appointment_System.Dto.Appointment;
import com.SpringBoot.Medical_Appointment_System.Repository.AppoinmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppoinmentRepository repository;

	// create data and add data
	public Appointment createAppoinment(Appointment appointment) {
		return repository.save(appointment);
	}

	// retrieve data by id
	public Appointment fetchByAppID(long id) {
		Optional<Appointment> byId = repository.findById(id);
		if (byId.isPresent())
			return byId.get();
		else
			return null;
	}

	// update doctor name & status based on id
	public int updateDocNameStatus(long id, String newDocName, boolean newStatus) {
		Optional<Appointment> byId = repository.findById(id);
		if (byId.isPresent()) {
			Appointment app = byId.get();
			app.setDoctorName(newDocName);
			app.setStatus(newStatus);
			repository.save(app);
			return 0;
		} else {
			return 1;
		}
	}

	// delete the appointment based on id
	public int deleteAppointment(Long id) {
		Optional<Appointment> byId = repository.findById(id);
		if (byId.isPresent()) {
			repository.deleteById(id);
			return 0;
		} else {
			return 1;
		}
	}

	// Delete appointments whose status is cancelled
	public int deleteCancellStatus(boolean status) {
		return repository.deleteCancellStatus(status);
	}

	// Retrieve appointments by doctor name.
	public List<Appointment> fetchByDocName(String docName) {
		return repository.fectByDocName(docName);
	}

	// Find appointments on a specific date
	public List<Appointment> fetchByDate(String date) {
		return repository.fetchByDate(date);
	}

	// display all appointments which are confirmed
	public List<Appointment> fetchByConfirmStatus(boolean status) {
		return repository.fetchByConfirmStatus(status);
	}

	// update patient name and appointment date based on ID
	public int updateNameDateById(long id, String newName, String newDate) {
		Optional<Appointment> byId = repository.findById(id);
		if (byId.isPresent()) {
			Appointment app = byId.get();
			app.setPatientName(newName);
			app.setAppointmentDate(newDate);
			repository.save(app);
			return 0;
		} else {
			return 1;
		}
	}
}
