package com.pao.laboratory03.exercise.service;

import com.pao.laboratory03.exercise.exception.StudentNotFoundException;
import com.pao.laboratory03.exercise.model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  *      f) Map<Subject, Double> getAveragePerSubject()
//  *         → calculează media pe fiecare materie (din toți studenții care au notă)
public class StudentService {
    private List<Student> students;

    private StudentService() {
        this.students = new ArrayList<>();
    }

    private static class Holder {
        private static final StudentService INSTANCE = new StudentService();
    }

    public static StudentService getInstance() {
        return Holder.INSTANCE;
    }

    public void addStudent(String name, int age){
        try {
            for (Student stud : students) {
                if(stud.getName().equals(name))
                    throw new RuntimeException();
            }

            Student stud = new Student(name, age);
            students.add(stud);
        } catch (RuntimeException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }

    public Student findByName(String name){
        try {
            for (Student stud : students) {
                if(stud.getName().equals(name))
                    return stud;
            }
            throw new StudentNotFoundException(name);
        } catch (StudentNotFoundException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
        return null;
    }

    public void addGrade(String studentName, Subject subject, double grade){
        findByName(studentName).addGrade(subject, grade);
    }
    
    public void printAllStudents(){
        for(Student st : students){
            System.out.println(st.toString());
        }
    }

    public void printTopStudents(){
        students.sort((o1, o2) -> Double.compare(o1.getAverage(), o2.getAverage()));
        this.printAllStudents();
    }

    
    public Map<Subject, Double> getAveragePerSubject(){
        Map<Subject, Double> gradesTotal = new HashMap<>();
        Map<Subject, Integer> gradesNr = new HashMap<>();
        for (Student st : students) {
            for (Map.Entry<Subject, Double> grade : st.getGrades().entrySet()) {
                if(grade.getValue() != 0){
                    if(!gradesNr.containsKey(grade.getKey())){
                        gradesTotal.put(grade.getKey(), 0.0);
                        gradesNr.put(grade.getKey(), 0);
                    }
                    gradesTotal.put(grade.getKey(), gradesTotal.get(grade.getKey()) + grade.getValue());
                    gradesNr.put(grade.getKey(), gradesNr.get(grade.getKey()) + 1);
                }
            }
        }
        for (Map.Entry<Subject, Double> entry : gradesTotal.entrySet()) {
            gradesTotal.put(entry.getKey(), entry.getValue() / gradesNr.get(entry.getKey()));
        }
        return gradesTotal;
    }
}
