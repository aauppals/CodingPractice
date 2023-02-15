import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparatorPractice {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(69, "Kanjar"));
        students.add(new Student(19, "Ahmad"));
        students.add(new Student(271, "Beght"));

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.rollNo > o2.rollNo)
                    return 1;

                return -1;
            }
        };

        Collections.sort(students, comparator);
        //Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student { //implements Comparable<Student>
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Student o) {
//        if (this.rollNo > o.rollNo)
//            return 1;
//
//        return -1;
//    }
}
