package com.pao.laboratory03.exercise.model;

import com.pao.laboratory03.exercise.exception.InvalidGradeException;
import com.pao.laboratory03.exercise.exception.InvalidStudentException;
import java.util.*;

public class Student {
    private String name;
    private int age;
    private Map<Subject, Double> grades;

    public Student(String name, int age){
        this.name = name;
        this.grades = new HashMap<>();
        
        try {
            if(age < 18 || age > 60)
                throw new InvalidStudentException(age);
            this.age = age;
        } catch (InvalidStudentException e) {
            System.out.println("Prins InvalidStudentException in validateAge: " + e.getMessage());
        }
        
    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public Map<Subject, Double> getGrades(){return grades;}

    public void addGrade(Subject subject, double grade){
        try {
            if(grade < 1 || grade > 10)
                throw new InvalidGradeException(grade);
            grades.put(subject, grade);
        } catch (InvalidGradeException e) {
            System.out.println("Prins InvalidStudentException in validateAge: " + e.getMessage());
        }
    }

    public double getAverage(){
        double avg = 0;
        int nrGrades = 0;
        for (Map.Entry<Subject, Double> entry : grades.entrySet()){
            if(entry.getValue() != 0){
                avg += entry.getValue();
                nrGrades++;
            }
        }
        if(nrGrades != 0){
            return avg / nrGrades;
        }
        return 0;
    }

    @Override public String toString(){
        return "Student {name=\"" + this.getName() + "\", age=" + this.getAge() + ", avg=" + this.getAverage() + "}";
    }

}
