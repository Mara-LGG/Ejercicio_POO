package org.generation.sistema.model;

public class Student {
    private String firstName;
    private String lastName;
    private int registration;
    private int grade;
    private int year;

    // --- CONSTRUCTORES (Sobrecarga de 3 constructores) ---

    // Constructor por defecto
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = 2026;
        this.grade = 0;
        this.year = 1;
    }

    // Constructor con datos básicos
    public Student(String firstName, String lastName, int registration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.grade = 0;
        this.year = 1;
    }

    // Constructor completo
    public Student(String firstName, String lastName, int registration, int grade, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.grade = grade;
        this.year = year;
    }

    // --- MÉTODOS SOLICITADOS ---

    public void printFullName() {
        System.out.println(firstName + " " + lastName);
    }

    public boolean isApproved() {
        return this.grade >= 60;
    }

    public int changeYearIfApproved() {
        if (isApproved()) {
            this.year += 1;
            System.out.println("Congratulations " + firstName + "! Has sido aprobado/a al año " + this.year);
        } else {
            System.out.println(firstName + " no alcanzó la calificación mínima para avanzar.");
        }
        return this.year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registration=" + registration +
                ", grade=" + grade +
                ", year=" + year +
                '}';
    }

    // --- GETTERS Y SETTERS ---

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getRegistration() { return registration; }
    public void setRegistration(int registration) { this.registration = registration; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}

