package com.yashaswi.sm.service;

import java.util.List;

import com.yashaswi.sm.api.Student;
import com.yashaswi.sm.api.StudentDTO;

public interface StudentService {
	List<Student> loadAllStudents();
	void saveStudent(StudentDTO student);
	StudentDTO getStudent(int id);
	void updateStudent(StudentDTO student);
	void deleteStudent(int id);
}
