/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.derisitos.gestiondeunjean;

import java.util.Scanner;

/**
 *
 * @author Dereck
 */

public class Jean {
    String codigo, color, talla, estadoTela;
    boolean tenido;
    int cantidadTenidos, cantidadBotones;
    double precio, humedad;
    // El lavado reduce un teñido, pero nunca permite valores negativos.
    public void lavar() {
        if (tenido && cantidadTenidos > 0) {
            cantidadTenidos--;
            if (cantidadTenidos == 0) tenido = false;
            System.out.println("Jean lavado. Teñidos restantes: " + cantidadTenidos);
        } else {
            System.out.println("El jean no tiene teñidos disponibles para disminuir.");
        }
    }
    // Cada secado disminuye la humedad en 10 puntos.
    public void secar() {
        if (humedad > 0) {
            humedad -= 10;
            if (humedad < 0) humedad = 0;
            System.out.printf("Jean secado. Humedad actual: %.2f%%%n", humedad);
        } else {
            System.out.println("El jean ya está completamente seco.");
        }
    }
    public void mostrarDatos() {
        System.out.println("\n--- DATOS DEL JEAN ---");
        System.out.println("Código: " + codigo);
        System.out.println("Color: " + color);
        System.out.println("Talla: " + talla);
        System.out.println("Fue teñido: " + (tenido ? "Sí" : "No"));
        System.out.println("Cantidad de teñidos: " + cantidadTenidos);
        System.out.printf("Precio: $%.2f%n", precio);
        System.out.println("Cantidad de botones: " + cantidadBotones);
        System.out.printf("Humedad: %.2f%%%n", humedad);
        System.out.println("Estado de la tela: " + estadoTela);
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Jean jean = new Jean();
        int respuestaTenido, opcionEstado, opcion;
        System.out.print("Código del jean: ");
        jean.codigo = entrada.nextLine();
        while (jean.codigo.trim().isEmpty()) {
            System.out.print("El código no puede estar vacío. Ingrese nuevamente: ");
            jean.codigo = entrada.nextLine();
        }
        System.out.print("Color: ");
        jean.color = entrada.nextLine();
        while (jean.color.trim().isEmpty()) {
            System.out.print("El color no puede estar vacío. Ingrese nuevamente: ");
            jean.color = entrada.nextLine();
        }
        System.out.print("Talla: ");
        jean.talla = entrada.nextLine();
        while (jean.talla.trim().isEmpty()) {
            System.out.print("La talla no puede estar vacía. Ingrese nuevamente: ");
            jean.talla = entrada.nextLine();
        }
        do {
            System.out.print("¿Fue teñido? (1 Sí, 0 No): ");
            respuestaTenido = entrada.nextInt();
            if (respuestaTenido != 0 && respuestaTenido != 1)
                System.out.println("Respuesta inválida.");
        } while (respuestaTenido != 0 && respuestaTenido != 1);
        jean.tenido = respuestaTenido == 1;
        if (jean.tenido) {
            do {
                System.out.print("Cantidad de teñidos (mayor que 0): ");
                jean.cantidadTenidos = entrada.nextInt();
                if (jean.cantidadTenidos <= 0) System.out.println("Cantidad inválida.");
            } while (jean.cantidadTenidos <= 0);
        } else {
            jean.cantidadTenidos = 0;
        }
        do {
            System.out.print("Precio (mayor o igual que 0): $ ");
            jean.precio = entrada.nextDouble();
            if (jean.precio < 0) System.out.println("Precio inválido.");
        } while (jean.precio < 0);
        do {
            System.out.print("Cantidad de botones (0 o más): ");
            jean.cantidadBotones = entrada.nextInt();
            if (jean.cantidadBotones < 0) System.out.println("Cantidad inválida.");
        } while (jean.cantidadBotones < 0);
        do {
            System.out.print("Humedad del jean (0 a 100): ");
            jean.humedad = entrada.nextDouble();
            if (jean.humedad < 0 || jean.humedad > 100)
                System.out.println("Humedad inválida.");
        } while (jean.humedad < 0 || jean.humedad > 100);
        do {
            System.out.print("Estado de la tela (1 Buena, 2 Regular, 3 Dañada): ");
            opcionEstado = entrada.nextInt();
            if (opcionEstado < 1 || opcionEstado > 3) System.out.println("Estado inválido.");
        } while (opcionEstado < 1 || opcionEstado > 3);
        if (opcionEstado == 1) jean.estadoTela = "Buena";
        else if (opcionEstado == 2) jean.estadoTela = "Regular";
        else jean.estadoTela = "Dañada";
        // Menú principal del programa.
        do {
            System.out.println("\n--- GESTIÓN DEL JEAN ---");
            System.out.println("1. Mostrar datos");
            System.out.println("2. Lavar jean");
            System.out.println("3. Secar jean");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1: jean.mostrarDatos(); break;
                case 2: jean.lavar(); break;
                case 3: jean.secar(); break;
                case 4: System.out.println("Programa finalizado."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
        entrada.close();
    }
}

