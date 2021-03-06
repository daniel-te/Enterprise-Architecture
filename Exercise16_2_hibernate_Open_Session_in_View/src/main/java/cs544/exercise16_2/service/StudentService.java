package cs544.exercise16_2.service;

import cs544.exercise16_2.dao.StudentDAO;
import cs544.exercise16_2.domain.Student;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		return studentdao.load(studentid);
	}
}
