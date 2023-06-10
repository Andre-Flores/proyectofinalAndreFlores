package proyecto;

import java.util.Scanner;

public class Proyecto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroEstudiantes;
        int numeroAsignaturas;

        System.out.print("Ingrese el numero de estudiantes: ");
        numeroEstudiantes = scanner.nextInt();

        System.out.print("Ingrese el numero de asignaturas: ");
        numeroAsignaturas = scanner.nextInt();

        double[][] calificaciones = new double[numeroEstudiantes][numeroAsignaturas];

        // Ingresar las calificaciones de los estudiantes
        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.println("Ingrese las calificaciones del estudiante " + (i + 1) + ":");
            for (int j = 0; j < numeroAsignaturas; j++) {
                double calificacion;
                do {
                    System.out.print("Nota en la asignatura " + (j + 1) + ": ");
                    calificacion = scanner.nextDouble();
                    if (calificacion < 0 || calificacion > 100) {
                        System.out.println("Error: La calificación debe estar entre 0 y 100.");
                    }
                } while (calificacion < 0 || calificacion > 100);
                calificaciones[i][j] = calificacion;
            }
        }
// \n ES COMO UN ENTER Y \t ES COMO UN TAB
        // Mostrar las calificaciones ingresadas
        System.out.println("\nNotas ingresadas:");
        System.out.print("Estudiante/Asignatura\t");
        for (int j = 0; j < numeroAsignaturas; j++) {
            System.out.print("Asignatura " + (j + 1) + "\t");
        }
        System.out.println();
        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.print("Estudiante " + (i + 1) + ":\t\t");
            for (int j = 0; j < numeroAsignaturas; j++) {
                System.out.print(calificaciones[i][j] + "\t\t");
            }
            System.out.println();
        }

        // Calcular promedio por estudiante
        double[] promediosEstudiantes = calcPromediosEstudiantes(calificaciones);
        System.out.println("\nPromedio por estudiante:");
        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + promediosEstudiantes[i]);
        }

        // Calcular promedio por asignatura
        double[] promediosAsignaturas = calcPromediosAsignaturas(calificaciones);
        System.out.println("\nPromedio por asignatura:");
        for (int j = 0; j < numeroAsignaturas; j++) {
            System.out.println("Asignatura " + (j + 1) + ": " + promediosAsignaturas[j]);
        }

        // Calcular promedio general
        double promedioGeneral = calcPromedioGeneral(promediosEstudiantes);
        System.out.println("\nPromedio general del grupo: " + promedioGeneral);
    }

    // Método para calcular el promedio por estudiante
    public static double[] calcPromediosEstudiantes(double[][] calificaciones) {
        int numEstudiantes = calificaciones.length;
        int numAsignaturas = calificaciones[0].length;
        double[] promediosEstudiantes = new double[numEstudiantes];

        for (int i = 0; i < numEstudiantes; i++) {
            double suma = 0;
            for (int j = 0; j < numAsignaturas; j++) {
                suma += calificaciones[i][j];
            }
            promediosEstudiantes[i] = suma / numAsignaturas;
        }

        return promediosEstudiantes;
    }

    // Metodo para calcular el promedio por clase
    public static double[] calcPromediosAsignaturas(double[][] calificaciones) {
        int numeroEstudiantes = calificaciones.length;
        int numeroAsignaturas = calificaciones[0].length;
        double[] promediosAsignaturas = new double[numeroAsignaturas];

        for (int j = 0; j < numeroAsignaturas; j++) {
            double suma = 0;
            for (int i = 0; i < numeroEstudiantes; i++) {
                suma += calificaciones[i][j];
            }
            promediosAsignaturas[j] = suma / numeroEstudiantes;
        }

        return promediosAsignaturas;
    }

    // Metodo calcular el promedio general del grupo
    public static double calcPromedioGeneral(double[] promediosEstudiantes) {
        int numeroEstudiantes = promediosEstudiantes.length;
        double suma = 0;
        for (int i = 0; i < numeroEstudiantes; i++) {
            suma += promediosEstudiantes[i];
        }
        return suma / numeroEstudiantes;
    }
}
