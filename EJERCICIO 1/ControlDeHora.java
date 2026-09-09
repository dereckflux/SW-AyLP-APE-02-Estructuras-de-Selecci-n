/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.derisitos.controldehora;

import java.util.Scanner;

/**
 *
 * @author Dereck
 */
public class ControlDeHora {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int horas, minutos, segundos, cambiar;
        do {
            do {
                System.out.print("Ingrese las horas (0 a 23): ");
                horas = entrada.nextInt();
                if (horas < 0 || horas > 23)
                    System.out.println("Hora inválida.");
            } while (horas < 0 || horas > 23);
            do {
                System.out.print("Ingrese los minutos (0 a 59): ");
                minutos = entrada.nextInt();
                if (minutos < 0 || minutos > 59)
                    System.out.println("Minutos inválidos.");
            } while (minutos < 0 || minutos > 59);
            do {
                System.out.print("Ingrese los segundos (0 a 59): ");
                segundos = entrada.nextInt();
                if (segundos < 0 || segundos > 59)
                    System.out.println("Segundos inválidos.");
            } while (segundos < 0 || segundos > 59);
            System.out.printf("Hora registrada: %02d:%02d:%02d%n",
                    horas, minutos, segundos);
            do {
                System.out.print("¿Desea cambiar la hora? (1 Sí, 0 No): ");
                cambiar = entrada.nextInt();
                if (cambiar != 0 && cambiar != 1)
                    System.out.println("Respuesta inválida.");
            } while (cambiar != 0 && cambiar != 1);
        } while (cambiar == 1);
        System.out.println("Programa finalizado.");
        entrada.close();
    }
}
