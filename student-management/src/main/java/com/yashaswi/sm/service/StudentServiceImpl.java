package com.yashaswi.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashaswi.sm.api.Student;
import com.yashaswi.sm.api.StudentDTO;
import com.yashaswi.sm.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<Student> loadAllStudents() {
		List<Student> students = studentDAO.loadAllStudents();
		return students;
	}

	@Override
	public void saveStudent(StudentDTO student) {
		studentDAO.addStudent(student);
		System.out.println(student.getStudentName()+"is saved to database..");
	}

	@Override
	public StudentDTO getStudent(int id) {
		Student student = studentDAO.getStudent(id);
		
		StudentDTO studentInfo = new StudentDTO();
		studentInfo.setId(student.getId());
		studentInfo.setStudentName(student.getName());
		studentInfo.setMobileNumber(student.getMobile());
		studentInfo.setCountry(student.getCountry());
		
		return studentInfo;
	}

	@Override
	public void updateStudent(StudentDTO studentInfo) {
		Student student = new Student();
		student.setId(studentInfo.getId());
		student.setName(studentInfo.getStudentName());
		student.setMobile(studentInfo.getMobileNumber());
		student.setCountry(studentInfo.getCountry());
		
		studentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
		
	}

}
