package comparable;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student(17,3);
        Student st2 = new Student(18,1);
        Student st3 = new Student(17, 2);

        Comparator comparatorClassNumber = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.classNumber - o2.classNumber > 0) {
                    System.out.println(String.format("앞의 애가 더 클래스넘버가 더 크네!"));
                    return 1;
                } else if (o1.classNumber == o2.classNumber) {
                    System.out.println(String.format("두 학생의 클래스 번호가 같습니다."));
                    return 0;
                }
                else {
                    System.out.println(String.format("뒤의 애가 더 클래스넘버가 더 크네!"));
                    return -1;
                }
            }
        };

        int maxClassNumber = comparatorClassNumber.compare(st1,st2);
        maxClassNumber = comparatorClassNumber.compare(st2,st3);
        maxClassNumber = comparatorClassNumber.compare(st1,st3);
    }
}

class Student {
    int age;
    int classNumber;

    Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }
}
