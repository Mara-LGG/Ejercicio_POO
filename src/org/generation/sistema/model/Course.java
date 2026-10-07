package org.generation.sistema.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String professorName;
    private int year;
    private List<Student> enrolledStudents;

    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
        this.enrolledStudents = new ArrayList<>();
    }

    // --- MÉTODOS DE INSCRIPCIÓN ---

    public void enroll(Student student) {
        if (student != null && !enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println("Estudiante " + student.getFirstName() + " inscrito con éxito.");
        }
    }

    // Sobrecarga de métod para inscribir un arreglo de estudiantes
    public void enroll(Student[] students) {
        if (students != null) {
            for (Student s : students) {
                enroll(s);
            }
        }
    }

    public void unEnroll(Student student) {
        if (enrolledStudents.contains(student)) {
            enrolledStudents.remove(student);
            System.out.println("Estudiante " + student.getFirstName() + " dado de baja.");
        } else {
            System.out.println("El estudiante no se encuentra en el curso.");
        }
    }

    public int countStudents() {
        return enrolledStudents.size();
    }

    public int bestGrade() {
        if (enrolledStudents.isEmpty()) return 0;

        int maxGrade = enrolledStudents.get(0).getGrade();
        for (Student s : enrolledStudents) {
            if (s.getGrade() > maxGrade) {
                maxGrade = s.getGrade();
            }
        }
        return maxGrade;
    }

    // --- MÉTODOS EXTRA ---

    public double calculateAverageGrade() {
        if (enrolledStudents.isEmpty()) return 0.0;

        double sum = 0;
        for (Student s : enrolledStudents) {
            sum += s.getGrade();
        }
        return sum / enrolledStudents.size();
    }

    public void printRanking() {
        System.out.println("\n--- CLASIFICACIÓN DEL CURSO " + courseName.toUpperCase() + " ---");
        
        List<Student> ranking = new ArrayList<>(enrolledStudents);
        ranking.sort((s1, s2) -> Integer.compare(s2.getGrade(), s1.getGrade()));

        for (int i = 0; i < ranking.size(); i++) {
            Student s = ranking.get(i);
            System.out.println((i + 1) + ". " + s.getFirstName() + " " + s.getLastName() + " - Calificación: " + s.getGrade());
        }
    }

    public void printAboveAverage() {
        double avg = calculateAverageGrade();
        System.out.println("\n--- EVALUACIÓN RESPECTO AL PROMEDIO DEL CURSO (" + avg + ") ---");
        for (Student s : enrolledStudents) {
            String status = (s.getGrade() >= avg) ? "POR ENCIMA" : "POR DEBAJO";
            System.out.println(s.getFirstName() + " " + s.getLastName() + " (" + s.getGrade() + "): " + status + " del promedio.");
        }
    }

    // Getters y Setters
    public String getCourseName() { return courseName; }
    public String getProfessorName() { return professorName; }
    public int getYear() { return year; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
}