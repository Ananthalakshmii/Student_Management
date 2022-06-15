package com.accolite.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.entity.Student;
import com.accolite.repository.StudentRepo;
import com.accolite.service.StudentService;

@Controller
public class StudentController implements CommandLineRunner {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepo studentRepo;

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents()); //use it in thymeleaf
		return "students";
	}

	@Override
	public void run(String... args) throws Exception {
		Student s1=new Student(1L,"dswe","ewf","dwfe");
		studentRepo.save(s1);
		
		Student s2=new Student(2L,"few","defw","edwgr");
		studentRepo.save(s2);
		
		Student s3=new Student(3L,"sdvf","devfeffw","edrwgr");
		studentRepo.save(s3);
		
	}
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student=new Student();//empty student object to hold student form data
		model.addAttribute("student",student);
		return "create_student";	
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudents(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model) {
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
