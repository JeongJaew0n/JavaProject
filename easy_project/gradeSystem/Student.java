package gradeSystem;

import java.util.ArrayList;

public class Student {
	private int studentId; // An identifier of students
	private String studentName; // Names of students
	private Subject major; // Subjects that students has chose

	private ArrayList<Score> scoreList = new ArrayList<>();

	Student(int studentId, String studentName, Subject major) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.major = major;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentid) {
		this.studentId = studentid;
	}

	public void addSubjectScore(Score score) { // Add scores of this student
		scoreList.add(score);
	}

	public void setStudentName(String name) { // To set a name of this Student
		this.studentName = name;
	}

	public String getStudentName() { // To get a name of this Student
		return this.studentName;
	}

	public void setMajorSubejct(Subject majorSubject) { // To set a major subject of this student.
		this.major = majorSubject;
	}

	public Subject getMajorSubejct() {
		return this.major;
	}

}
