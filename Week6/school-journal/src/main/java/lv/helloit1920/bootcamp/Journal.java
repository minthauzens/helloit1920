package lv.helloit1920.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;

public class Journal {
    HashMap<String, Student> students;

    public Journal() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        this.students.put(student.getName(), student);
    }

    public void printStudents() {
        ArrayList<Student> sortedStudents = new ArrayList<>();
        HashMap<String, Student> base= new HashMap<>();
        for (String name : students.keySet()) {
            base.put(name, students.get(name));
        }
        while (base.size() > 0) {
            String maxName = getStudentWithMaxValue(base);
            Student max = base.get(maxName);
            base.remove(maxName);
            sortedStudents.add(max);
        }
        for (Student sortedStudent : sortedStudents) {
            System.out.println(sortedStudent);
        }
    }

    private String getStudentWithMaxValue(HashMap<String, Student> base) {
        double max = - Double.MAX_VALUE;
        String maxStudentName = null;
        for (String studentName : base.keySet()) {
            Student student = base.get(studentName);
            if (student.getAverageGrade() > max) {
                max = student.getAverageGrade();
                maxStudentName = studentName;
            }
        }
        return maxStudentName;
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
