package gradeSystem;

import java.util.ArrayList;

public class Subject {
	private int subjectid;
	private String subjectName;
	private int gradeType = Define.AB_TYPE; // 기본 타입이 ab(int타입 0값).

	ArrayList<Student> studentList = new ArrayList<>();

	Subject(String subjectName, int subjectid) {
		this.subjectid = subjectid;
		this.subjectName = subjectName;
	}

	public int getSubjectid() { // Subject ID
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubjectName() { // Subject Name
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getGradeType() { // grade Type
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() { // To get a List of Students
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void register(Student student){  //수강신청
		studentList.add(student);
	}

}
