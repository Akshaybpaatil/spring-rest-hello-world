package com.express.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.express.springdemo.config.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	// define endpoint for "/students" - return list of students

	public List<Student> loadStudents() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
		return theStudents;
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return loadStudents();
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if ((studentId >= theStudents.size() || (studentId < 0))) {

			throw new StudentNotFoundException("Student id not Found-" + studentId);
		}
		return theStudents.get(studentId);
	}

}
