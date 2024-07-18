package com.yashaswi.sm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yashaswi.sm.api.Student;
import com.yashaswi.sm.api.StudentDTO;
import com.yashaswi.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Student> loadAllStudents() {
		String sql = "select * from students";
		
		List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return studentList;
	}

	@Override
	public void addStudent(StudentDTO student) {
		String sql = "insert into students(name, mobile, country) values(?,?,?)";
		
		Object[] args = {student.getStudentName(), student.getMobileNumber(),
							student.getCountry()};
		
		jdbcTemplate.update(sql, args);
		
		System.out.println("1 record added..");
	}

	@Override
	public Student getStudent(int id) {
		String sql = "select * from students where id = ?";
		
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);

		return student;
	}

	@Override
	public void updateStudent(Student student) {
		String sql = "update students set name = ?, mobile = ?, country = ? where id = ?";
		Object[] data = {student.getName(),
							student.getMobile(),
							student.getCountry(),
							student.getId()};
		
		jdbcTemplate.update(sql, data);
		
		System.out.println("1 record updated...");
		
	}

	@Override
	public void deleteStudent(int id) {
		String sql = "delete from students where id = ?";
		
		jdbcTemplate.update(sql, id);
		
		System.out.println("1 record deleted...");
		
	}

}
