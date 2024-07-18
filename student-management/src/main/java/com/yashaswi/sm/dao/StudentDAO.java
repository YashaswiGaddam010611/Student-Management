package com.yashaswi.sm.dao;

import java.util.List;

import com.yashaswi.sm.api.Student;
import com.yashaswi.sm.api.StudentDTO;

public interface StudentDAO {
	List<Student> loadAllStudents();
	void addStudent(StudentDTO student);
	Student getStudent(int id);
	void updateStudent(Student student);
	void deleteStudent(int id);
}
