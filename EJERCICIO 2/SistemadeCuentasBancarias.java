/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.derisitos.sistemadecuentasbancarias;

import java.util.Scanner;

/**
 *
 * @author Dereck
 */
public class SistemadeCuentasBancarias {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String dni, numeroCuenta, tipoCuenta, numeroActual = "", tipoActual = "";
        String cuenta1 = "", cuenta2 = "", cuenta3 = "";
        String tipo1 = "", tipo2 = "", tipo3 = "";
        int cantidadCuentas, i, tipo, cuentaSeleccionada, destino, opcion;
        double saldoInicial, saldoActual = 0, saldoDestino = 0, monto;
        double saldo1 = 0, saldo2 = 0, saldo3 = 0;
        // Primero se registran los datos generales del cliente.
        System.out.print("Ingrese el DNI del cliente: ");
        dni = entrada.nextLine();
        while (dni.trim().isEmpty()) {
            System.out.print("El DNI no puede estar vacío. Ingrese nuevamente: ");
            dni = entrada.nextLine();
        }
        do {
            System.out.print("¿Cuántas cuentas desea crear? (1 a 3): ");
            cantidadCuentas = entrada.nextInt();
            if (cantidadCuentas < 1 || cantidadCuentas > 3)
                System.out.println("Cantidad de cuentas inválida.");
        } while (cantidadCuentas < 1 || cantidadCuentas > 3);
        // Se usa un for para crear solamente las cuentas solicitadas.
        for (i = 1; i <= cantidadCuentas; i++) {
            entrada.nextLine();
            System.out.print("Número de la cuenta " + i + ": ");
            numeroCuenta = entrada.nextLine();
            while (numeroCuenta.trim().isEmpty()) {
                System.out.print("El número no puede estar vacío. Ingrese nuevamente: ");
                numeroCuenta = entrada.nextLine();
            }
            do {
                System.out.print("Tipo (1 Ahorros, 2 Corriente): ");
                tipo = entrada.nextInt();
                if (tipo != 1 && tipo != 2) System.out.println("Tipo inválido.");
            } while (tipo != 1 && tipo != 2);
            tipoCuenta = tipo == 1 ? "Ahorros" : "Corriente";
            do {
                System.out.print("Saldo inicial: $ ");
                saldoInicial = entrada.nextDouble();
                if (saldoInicial < 0) System.out.println("El saldo no puede ser negativo.");
            } while (saldoInicial < 0);
            // Cada cuenta se guarda en variables simples, sin usar arreglos.
            switch (i) {
                case 1: cuenta1 = numeroCuenta; tipo1 = tipoCuenta; saldo1 = saldoInicial; break;
                case 2: cuenta2 = numeroCuenta; tipo2 = tipoCuenta; saldo2 = saldoInicial; break;
                case 3: cuenta3 = numeroCuenta; tipo3 = tipoCuenta; saldo3 = saldoInicial; break;
            }
        }
        // El menú se repite hasta que el usuario seleccione salir.
        do {
            System.out.print("Seleccione una cuenta (1 a " + cantidadCuentas + "): ");
            cuentaSeleccionada = entrada.nextInt();
        } while (cuentaSeleccionada < 1 || cuentaSeleccionada > cantidadCuentas);
        do {
            switch (cuentaSeleccionada) {
                case 1: numeroActual = cuenta1; tipoActual = tipo1; saldoActual = saldo1; break;
                case 2: numeroActual = cuenta2; tipoActual = tipo2; saldoActual = saldo2; break;
                case 3: numeroActual = cuenta3; tipoActual = tipo3; saldoActual = saldo3; break;
            }
            System.out.println("\n--- MENÚ BANCARIO ---");
            System.out.println("Cuenta seleccionada: " + numeroActual);
            System.out.println("1. Ver atributos de la cuenta");
            System.out.println("2. Enviar dinero");
            System.out.println("3. Recibir dinero");
            System.out.println("4. Transferir entre cuentas");
            System.out.println("5. Seleccionar otra cuenta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("DNI: " + dni);
                    System.out.println("Número: " + numeroActual);
                    System.out.println("Tipo: " + tipoActual);
                    System.out.printf("Saldo: $%.2f%n", saldoActual);
                    break;
                case 2:
                    do {
                        System.out.print("Monto a enviar: $ ");
                        monto = entrada.nextDouble();
                        if (monto <= 0 || monto > saldoActual)
                            System.out.println("Monto inválido o saldo insuficiente.");
                    } while (monto <= 0 || monto > saldoActual);
                    saldoActual -= monto;
                    if (cuentaSeleccionada == 1) saldo1 = saldoActual;
                    else if (cuentaSeleccionada == 2) saldo2 = saldoActual;
                    else saldo3 = saldoActual;
                    System.out.printf("Envío realizado. Saldo: $%.2f%n", saldoActual);
                    break;
                case 3:
                    do {
                        System.out.print("Monto a recibir: $ ");
                        monto = entrada.nextDouble();
                        if (monto <= 0) System.out.println("El monto debe ser positivo.");
                    } while (monto <= 0);
                    saldoActual += monto;
                    if (cuentaSeleccionada == 1) saldo1 = saldoActual;
                    else if (cuentaSeleccionada == 2) saldo2 = saldoActual;
                    else saldo3 = saldoActual;
                    System.out.printf("Dinero recibido. Saldo: $%.2f%n", saldoActual);
                    break;
                case 4:
                    // La transferencia modifica el saldo de dos cuentas del cliente.
                    if (cantidadCuentas == 1) {
                        System.out.println("No existe otra cuenta para transferir.");
                    } else {
                        do {
                            System.out.print("Cuenta destino (1 a " + cantidadCuentas + "): ");
                            destino = entrada.nextInt();
                            if (destino < 1 || destino > cantidadCuentas || destino == cuentaSeleccionada)
                                System.out.println("Cuenta destino inválida.");
                        } while (destino < 1 || destino > cantidadCuentas || destino == cuentaSeleccionada);
                        do {
                            System.out.print("Monto a transferir: $ ");
                            monto = entrada.nextDouble();
                            if (monto <= 0 || monto > saldoActual)
                                System.out.println("Monto inválido o saldo insuficiente.");
                        } while (monto <= 0 || monto > saldoActual);
                        if (destino == 1) saldoDestino = saldo1;
                        else if (destino == 2) saldoDestino = saldo2;
                        else saldoDestino = saldo3;
                        saldoActual -= monto;
                        saldoDestino += monto;
                        if (cuentaSeleccionada == 1) saldo1 = saldoActual;
                        else if (cuentaSeleccionada == 2) saldo2 = saldoActual;
                        else saldo3 = saldoActual;
                        if (destino == 1) saldo1 = saldoDestino;
                        else if (destino == 2) saldo2 = saldoDestino;
                        else saldo3 = saldoDestino;
                        System.out.printf("Transferencia realizada. Saldo origen: $%.2f%n", saldoActual);
                    }
                    break;
                case 5:
                    do {
                        System.out.print("Seleccione una cuenta (1 a " + cantidadCuentas + "): ");
                        cuentaSeleccionada = entrada.nextInt();
                    } while (cuentaSeleccionada < 1 || cuentaSeleccionada > cantidadCuentas);
                    break;
                case 6:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
        entrada.close();

    }
}
