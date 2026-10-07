package org.generation.sistema;

import org.generation.sistema.model.Course;
import org.generation.sistema.model.Student;

public class Main {
    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("1. PRUEBA DE CONSTRUCTORES Y METODOS DE STUDENT");
        System.out.println("==================================================");
        // Pruebas de los 3 constructores
        Student s1 = new Student("Ana", "García");
        Student s2 = new Student("Carlos", "López", 1002);
        Student s3 = new Student("María", "Rodríguez", 1003, 85, 2);
        Student s4 = new Student("Pedro", "Sánchez", 1004, 50, 1);

        System.out.print("Nombre completo de s1: ");
        s1.printFullName();
        System.out.println("ToString de s3: " + s3);
        System.out.println();

        System.out.println("==================================================");
        System.out.println("2. EVALUACIÓN DE APROBACIÓN Y CAMBIO DE AÑO");
        System.out.println("==================================================");

        // Modificamos calificación con setter para probar
        s1.setGrade(75);
        System.out.println("¿Ana está aprobada? (Calificación 75): " + s1.isApproved());
        s1.changeYearIfApproved(); // Pasa a año 2

        System.out.println("¿Pedro está aprobado? (Calificación 50): " + s4.isApproved());
        s4.changeYearIfApproved(); // No avanza de año
        System.out.println();

        System.out.println("==================================================");
        System.out.println("3. CASO LÍMITE: OPERACIONES EN UN CURSO VACÍO");
        System.out.println("==================================================");
        Course mathCourse = new Course("Matemáticas Avanzadas", "Dr. Ramírez", 2026);

        System.out.println("Estudiantes en curso vacío: " + mathCourse.countStudents());
        System.out.println("Mejor calificación en curso vacío: " + mathCourse.bestGrade());
        System.out.println("Promedio en curso vacío: " + mathCourse.calculateAverageGrade());
        System.out.println();

        System.out.println("==================================================");
        System.out.println("4. INSCRIPCIÓN INDIVIDUAL Y PREVENCIÓN DE DUPLICADOS");
        System.out.println("==================================================");
        mathCourse.enroll(s1);
        mathCourse.enroll(s2);

        // Intento de inscribir al mismo estudiante de nuevo
        System.out.println("Intento de re-inscribir a Ana:");
        mathCourse.enroll(s1);

        // Intento de inscribir un objeto nulo
        System.out.println("Intento de inscribir null:");
        mathCourse.enroll((Student) null);

        System.out.println("Total inscritos tras inscripciones individuales: " + mathCourse.countStudents());
        System.out.println();

        System.out.println("==================================================");
        System.out.println("5. INSCRIPCIÓN MASIVA MEDIANTE ARREGLO (SOBRECARGA)");
        System.out.println("==================================================");
        Student s5 = new Student("Laura", "Gómez", 1005, 92, 1);
        Student s6 = new Student("Jorge", "Martínez", 1006, 68, 1);
        Student s7 = new Student("Sofia", "Hernández", 1007, 45, 1);

        Student[] nuevosEstudiantes = {s3, s4, s5, s6, s7};
        mathCourse.enroll(nuevosEstudiantes);

        System.out.println("Total inscritos tras inscripción en lote: " + mathCourse.countStudents());
        System.out.println();

        System.out.println("==================================================");
        System.out.println("6. DESINSCRIPCIÓN DE ESTUDIANTES (UNENROLL)");
        System.out.println("==================================================");
        // Baja de estudiante existente
        mathCourse.unEnroll(s4); // Pedro es dado de baja

        // Intento de dar de baja a un estudiante que ya no está / nunca estuvo
        Student s8 = new Student("Fernando", "Torres", 9999);
        mathCourse.unEnroll(s8);

        System.out.println("Total inscritos actual: " + mathCourse.countStudents());
        System.out.println();

        System.out.println("==================================================");
        System.out.println("7. MÉTRICAS, CLASIFICACIÓN Y EVALUACIÓN DE PROMEDIO");
        System.out.println("==================================================");
        System.out.println("Mejor calificación del curso: " + mathCourse.bestGrade());
        System.out.println("Promedio general del curso: " + mathCourse.calculateAverageGrade());

        // Reportes tabulados / impresiones ordenadas
        mathCourse.printRanking();
        mathCourse.printAboveAverage();
    }
}