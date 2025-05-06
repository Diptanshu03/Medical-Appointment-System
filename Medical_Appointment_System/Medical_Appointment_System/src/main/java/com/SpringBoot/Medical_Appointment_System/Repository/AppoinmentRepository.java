package com.SpringBoot.Medical_Appointment_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.SpringBoot.Medical_Appointment_System.Dto.Appointment;

import jakarta.transaction.Transactional;

public interface AppoinmentRepository extends JpaRepository<Appointment, Long> {

	@Modifying
	@Transactional
	@Query("delete from Appointment a where a.status=?1")
	public int deleteCancellStatus(boolean status);

	@Query("select a from Appointment a where a.doctorName=?1")
	public List<Appointment> fectByDocName(String docName);

	@Query("select a from Appointment a where a.appointmentDate=?1")
	public List<Appointment> fetchByDate(String date);

	@Query("select a from Appointment a where a.status=?1")
	public List<Appointment> fetchByConfirmStatus(boolean status);

}
