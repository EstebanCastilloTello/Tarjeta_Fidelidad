package com.fidelidad;

import java.time.LocalDate;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteRepository clienteRepo = new ClienteRepository();
    private static final FidelidadService fidelidadService = new FidelidadService(clienteRepo);

    public static void main(String[] args) {
        while (true) {
            mostrarMenuPrincipal();
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> menuClientes();
                case "2" -> menuCompras();
                case "3" -> mostrarPuntosYNivel();
                case "4" -> {
                    System.out.println("¡Hasta luego!");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Gestión de Clientes");
        System.out.println("2. Gestión de Compras");
        System.out.println("3. Mostrar Puntos / Nivel");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // -------------------------
    // SUBMENÚ CLIENTES
    private static void menuClientes() {
        System.out.println("\n--- Gestión de Clientes ---");
        System.out.println("1. Agregar");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print("Seleccione una opción: ");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1" -> agregarCliente();
            case "2" -> listarClientes();
            case "3" -> actualizarCliente();
            case "4" -> eliminarCliente();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void agregarCliente() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        try {
            Cliente cliente = new Cliente(id, nombre, correo);
            clienteRepo.agregar(cliente);
            System.out.println("Cliente agregado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarClientes() {
        for (Cliente c : clienteRepo.listar()) {
            System.out.printf("- [%s] %s | %s | %d pts | Nivel: %s\n",
                    c.getId(), c.getNombre(), c.getCorreo(), c.getPuntos(), c.getNivel());
        }
    }

    private static void actualizarCliente() {
        System.out.print("ID del cliente a actualizar: ");
        String id = scanner.nextLine();
        Cliente c = clienteRepo.buscar(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        c.setNombre(scanner.nextLine());
        System.out.print("Nuevo correo: ");
        String nuevoCorreo = scanner.nextLine();
        if (!nuevoCorreo.contains("@")) {
            System.out.println("Correo inválido.");
            return;
        }
        c.setCorreo(nuevoCorreo);
        clienteRepo.actualizar(c);
        System.out.println("Cliente actualizado.");
    }

    private static void eliminarCliente() {
        System.out.print("ID del cliente a eliminar: ");
        String id = scanner.nextLine();
        clienteRepo.eliminar(id);
        System.out.println("Cliente eliminado.");
    }

    // -------------------------
    // SUBMENÚ COMPRAS

    private static void menuCompras() {
        System.out.println("\n--- Registrar Compra ---");
        System.out.print("ID Compra: ");
        String idCompra = scanner.nextLine();
        System.out.print("ID Cliente: ");
        String idCliente = scanner.nextLine();
        System.out.print("Monto: ");
        double monto = Double.parseDouble(scanner.nextLine());
        LocalDate fecha = LocalDate.now();

        Compra compra = new Compra(idCompra, idCliente, monto, fecha);
        try {
            fidelidadService.registrarCompra(compra);
            System.out.println("Compra registrada correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------------
    // MOSTRAR PUNTOS Y NIVEL

    private static void mostrarPuntosYNivel() {
        System.out.print("ID del cliente: ");
        String id = scanner.nextLine();
        Cliente c = clienteRepo.buscar(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.printf("Puntos: %d | Nivel: %s\n", c.getPuntos(), c.getNivel());
    }
}
