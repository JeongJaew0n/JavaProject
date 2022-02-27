package gradeSystem;
//
import java.util.ArrayList;

public class GenerateGradeReport {

	School school = School.getInstance();
	public static final String TITLE = "수강생 학점 \t\t\n";
	public static final String HEADER = "이름	|	학번	|중점과목|		 점수		\n";
	public static final String LINE = "-------------------------------------\n";
	private StringBuffer buffer = new StringBuffer();

	public String getReport() {		//출력 내용 꾸미기
		ArrayList<Subject> subjectList = school.getSubjectList(); //
		for (Subject sub : subjectList) {
			makeHeader(sub);
			makeBody(sub);
			makeFooter();
		}
		return buffer.toString();
	}

	public void makeHeader(Subject subject) {	//출력 내용 헤드 부분.
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
	}

	public void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList();

		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append("	| ");
			buffer.append(student.getStudentId());
			buffer.append("	| ");
			buffer.append(student.getMajorSubejct().getSubjectName() + "\t");
			buffer.append("	| ");

			getScoreGrade(student, subject.getSubjectid());
			buffer.append("\n");
			buffer.append(LINE);
		}
	}

	public void getScoreGrade(Student student, int subjectId) {	//점수 출력을 위한 함수
		
		ArrayList<Score> scoreList = student.getScoreList();	//입력받은 학생 객체의 스코어들을 가져옴
		
		int majorId = student.getMajorSubejct().getSubjectid();	//중점과목 입력받음
		
		GradeEvaluation[] gradeEvaluation = { new BasicEvaluation(), new MajorEvaluation(), new PassFailEvaluation() }; // 학점 평가 클래스들

		for (int i = 0; i < scoreList.size(); i++) {

			Score score = scoreList.get(i);

			if (score.getSubject().getSubjectid() == subjectId) {	//함수의 인자로 넘겨받은 과목과 현재 선택된 점수의 과목과 일치하는지(수학점수 출력을 위해 호출 되었고 학생의 점수 목록중 수학 점수만을 가려내기 위한 조건문).

				String grade = null;

				if (score.getSubject().getSubjectid() == majorId) {	//중점 과목이라면
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
				}
				
				else if(score.getSubject().getSubjectid() == Define.ENGLISH) {
					grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
				}
				
				else{
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				}
				
				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");

			}

		}
	}

	public void makeFooter() {
		buffer.append("\n");
	}

}
