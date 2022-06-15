package com.accolite.service;

import java.util.List;
import java.util.Optional;

import com.accolite.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudents(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
