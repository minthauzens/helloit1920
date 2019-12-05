package lv.helloit1920.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Journal {
    HashMap<String, Student> students;

    public Journal() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        this.students.put(student.getName(), student);
    }

    public void printStudents() {
//        ArrayList<Student> sortedStudents = new ArrayList<>();
        List<Student> sortedStudents = students.values().stream().sorted((student1, student2) -> {
            var avg1 = student1.getAverageGrade();
            var avg2 = student2.getAverageGrade();
            return Double.compare(avg1, avg2);
        }).collect(Collectors.toList());

        for (Student sortedStudent : sortedStudents) {
            System.out.println(sortedStudent);
        }
    }


    public Student getStudent(String name) {
        if (!this.students.containsKey(name)) {
            return null;
        }
        return this.students.get(name);
    }

    public boolean isEmpty() {
        return this.students.size() == 0;
    }

}
