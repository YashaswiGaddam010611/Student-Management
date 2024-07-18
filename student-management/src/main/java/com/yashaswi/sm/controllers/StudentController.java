package com.yashaswi.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yashaswi.sm.api.Student;
import com.yashaswi.sm.api.StudentDTO;
import com.yashaswi.sm.service.StudentService;

@Controller("/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student")
	public String showStudentList(Model model) {
		
		List<Student> students = studentService.loadAllStudents();
		
		model.addAttribute("students",students);
		
		return "student-list";
	}
	
	@GetMapping("/add-student")
	public String showAddStudentPage(Model model) {
		model.addAttribute("studentInfo",new StudentDTO());
		return "add-student";
	}
	
	
	@PostMapping("/save-student")
	public String showUpdatedStudentList(StudentDTO studentInfo, Model model) {
		System.out.println(studentInfo);
		
		//if user wants to add new student details
		if(studentInfo.getId() == 0) {
			studentService.saveStudent(studentInfo);
		} else {
			//if user wants to update existing student details
			studentService.updateStudent(studentInfo);
		}
		
		return "redirect:/student";
	}
	
	@GetMapping("/updateStudent")
	public String showUpdateStudentPage(@RequestParam("userId")int id,Model model) {
		System.out.println("student has id: "+id+"is requesting to update..");
		
		StudentDTO studentInfo = studentService.getStudent(id);
		model.addAttribute("studentInfo", studentInfo);
		return "add-student";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId")int id) {
		studentService.deleteStudent(id);
		
		return "redirect:/student";
	}
}
