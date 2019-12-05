package lv.helloit1920.bootcamp;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public Student(String name, ArrayList<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void addGrade(int grade) {
        this.grades.add(grade);
    }

    public double getAverageGrade() {
        if (this.grades.size() == 0) {
            return -1;
        }
        int total = 0;
        for (Integer grade : grades) {
            total += grade;
        }

        return (double) total/grades.size();
    }

    @Override
    public String toString() {
        String averageGrade = (getAverageGrade() != -1) ? String.valueOf(getAverageGrade()) : "NaN";
        return this.name + " - average grade: " + averageGrade;
    }

    public void printGrades() {
        for (int i = 0; i < this.grades.size(); i++) {
            Integer grade = this.grades.get(i);
            if (i != this.grades.size() - 1) {
                System.out.print(grade + ", ");
            } else {
                System.out.print(grade + ";");
            }
        }
        System.out.println();
    }
}
