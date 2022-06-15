package com.accolite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.entity.Student;
import com.accolite.repository.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	public Student saveStudents(Student student) {
		return studentRepo.save(student);
}
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get();
	}
	
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public void deleteStudentById(Long id) {
		 studentRepo.deleteById(id);
	}
}
