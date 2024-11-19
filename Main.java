package competenciaatletica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Competencia competencia = new Competencia();
        int opcion;

        do {
            System.out.println("Menu de Competencia:");
            System.out.println("1.Registrar Atleta");
            System.out.println("2.Mostrar Datos del Campeon");
            System.out.println("3. Mostrar Atletas por Pais");
            System.out.println("4. Calcular Tiempo Promedio");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del atleta: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la nacionalidad del atleta: ");
                    String nacionalidad = scanner.nextLine();
                    System.out.print("Ingrese el tiempo del atleta (en segundos): ");
                    double tiempo = scanner.nextDouble();
                    competencia.registrarAtleta(nombre, nacionalidad, tiempo);
                }
                case 2 -> {
                    Atleta campeon = competencia.obtenerCampeon();
                    if (campeon != null) {
                        System.out.println("Datos del Campeón:");
                        System.out.println(campeon);
                    } else {
                        System.out.println("No hay atletas registrados.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el país a buscar: ");
                    String pais = scanner.nextLine();
                    System.out.println("Atletas de " + pais + ":");
                    competencia.mostrarAtletasPorPais(pais);
                }
                case 4 -> {
                    double promedio = competencia.calcularTiempoPromedio();
                    if (promedio > 0) {
                        System.out.println("El tiempo promedio de los atletas es: " + String.format("%.2f", promedio) + " segundos.");
                    } else {
                        System.out.println("No hay atletas registrados.");
                    }
                }
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida intente nuevamente");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
