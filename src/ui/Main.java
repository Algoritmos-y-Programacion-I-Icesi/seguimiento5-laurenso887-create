package ui;

import controller.Parque;
import model.*;
import java.util.Scanner;

public class Main {

    private static Parque parque = new Parque();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatosPrueba();
        int opcion;
        do {
            System.out.println("\n===== MAGICWORLD - MENÚ PRINCIPAL =====");
            System.out.println("1. Registrar atracción");
            System.out.println("2. Generar reporte de operaciones");
            System.out.println("3. Calcular ingreso total diario");
            System.out.println("4. Mostrar atracciones con clasificación de riesgo");
            System.out.println("5. Mostrar atracciones con alertas de capacidad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1: registrarAtraccion(); break;
                case 2: System.out.println(parque.generarReporteOperaciones()); break;
                case 3:
                    double total = parque.calcularIngresoTotalDiario();
                    System.out.printf("%nIngreso total diario del parque: $%.0f%n", total);
                    break;
                case 4: System.out.println(parque.mostrarClasificacionRiesgo()); break;
                case 5: System.out.println(parque.mostrarAlertasCapacidad()); break;
                case 0: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void registrarAtraccion() {
        System.out.println("\nTipo de atracción:");
        System.out.println("1. Simulador de realidad virtual");
        System.out.println("2. Juego infantil");
        System.out.println("3. Espectáculo pirotécnico");
        System.out.print("Seleccione: ");
        int tipo = leerEntero();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Zona: ");
        String zona = sc.nextLine().trim();
        System.out.print("Capacidad máxima: ");
        int capMax = leerEntero();
        System.out.print("Edad mínima: ");
        int edadMin = leerEntero();
        System.out.print("Visitantes hoy: ");
        int visitantes = leerEntero();
        System.out.print("Precio entrada: ");
        double precio = leerDouble();

        switch (tipo) {
            case 1:
                System.out.print("Número de estaciones: ");
                int estaciones = leerEntero();
                System.out.print("¿Requiere anteojos especiales? (s/n): ");
                boolean anteojos = sc.nextLine().trim().equalsIgnoreCase("s");
                parque.registrarAtraccion(new SimuladorVR(nombre, zona, capMax, edadMin,
                        visitantes, precio, estaciones, anteojos));
                System.out.println("✓ Simulador VR registrado.");
                break;
            case 2:
                System.out.print("Edad máxima: ");
                int edadMax = leerEntero();
                System.out.print("¿Tiene supervisión permanente? (s/n): ");
                boolean supervision = sc.nextLine().trim().equalsIgnoreCase("s");
                parque.registrarAtraccion(new JuegoInfantil(nombre, zona, capMax, edadMin,
                        visitantes, precio, edadMax, supervision));
                System.out.println("✓ Juego infantil registrado.");
                break;
            case 3:
                System.out.print("Duración en minutos: ");
                int duracion = leerEntero();
                System.out.print("¿Usa material peligroso certificado? (s/n): ");
                boolean material = sc.nextLine().trim().equalsIgnoreCase("s");
                parque.registrarAtraccion(new EspectaculoPirotecnico(nombre, zona, capMax, edadMin,
                        visitantes, precio, duracion, material));
                System.out.println("✓ Espectáculo pirotécnico registrado.");
                break;
            default:
                System.out.println("Tipo inválido.");
        }
    }

    private static void cargarDatosPrueba() {
        parque.registrarAtraccion(new SimuladorVR("VR Galaxy", "Zona Futura", 50, 12,
                55, 25000, 25, true));
        parque.registrarAtraccion(new SimuladorVR("Dream Rider", "Zona Centro", 30, 10,
                28, 20000, 15, false));
        parque.registrarAtraccion(new JuegoInfantil("Castillo Mágico", "Zona Infantil", 40, 3,
                45, 15000, 10, true));
        parque.registrarAtraccion(new JuegoInfantil("Carros Chocones Mini", "Zona Infantil", 20, 4,
                22, 12000, 12, false));
        parque.registrarAtraccion(new EspectaculoPirotecnico("Noche de Fuego", "Zona Espectáculos", 200, 8,
                185, 35000, 75, true));
        parque.registrarAtraccion(new EspectaculoPirotecnico("Lluvia de Estrellas", "Zona Abierta", 150, 5,
                140, 28000, 45, false));
    }

    private static int leerEntero() {
        int valor = 0;
        try {
            valor = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Se usará 0.");
        }
        return valor;
    }

    private static double leerDouble() {
        double valor = 0;
        try {
            valor = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Se usará 0.");
        }
        return valor;
    }
}
