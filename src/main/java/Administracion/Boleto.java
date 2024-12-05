
package Administracion;

import Cliente.Usuario;
import java.util.Scanner;

public class Boleto {

    public static void realizarPago(Scanner scanner, Usuario usuario, int cantidadAdultos, int cantidadNinos) {
        double total = (cantidadAdultos * 80) + (cantidadNinos * 50);
        System.out.println("Total a pagar: $" + total);

        System.out.print("Nombre del titular de la tarjeta: ");
        String nombreTitular = scanner.nextLine();

        System.out.print("Número de la tarjeta: ");
        String numeroTarjeta = scanner.nextLine();

        System.out.print("Fecha de vigencia (MM/AA): ");
        String fechaVigencia = scanner.nextLine();

        System.out.print("Código de verificación: ");
        String codigoVerificacion = scanner.nextLine();

        System.out.print("Tipo de tarjeta (Débito o Crédito): ");
        String tipoTarjeta = scanner.nextLine();

        System.out.print("¿Desea guardar los datos de su tarjeta para futuras compras? (sí/no): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("sí")) {
            usuario.guardarTarjeta(nombreTitular, numeroTarjeta, fechaVigencia, codigoVerificacion, tipoTarjeta);
            System.out.println("Datos de la tarjeta guardados.");
        }

        System.out.println("Pago realizado con éxito. Disfrute su película y productos!");
    }

    public static void realizarPagoFinal(Scanner scanner, Usuario usuario, double total) {
        System.out.println("Total a pagar: $" + total);

        System.out.print("Nombre del titular de la tarjeta: ");
        String nombreTitular = scanner.nextLine();

        System.out.print("Número de la tarjeta: ");
        String numeroTarjeta = scanner.nextLine();

        System.out.print("Fecha de vigencia (MM/AA): ");
        String fechaVigencia = scanner.nextLine();

        System.out.print("Código de verificación: ");
        String codigoVerificacion = scanner.nextLine();

        System.out.print("Tipo de tarjeta (Débito o Crédito): ");
        String tipoTarjeta = scanner.nextLine();

        System.out.print("¿Desea guardar los datos de su tarjeta para futuras compras? (sí/no): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("sí")) {
            usuario.guardarTarjeta(nombreTitular, numeroTarjeta, fechaVigencia, codigoVerificacion, tipoTarjeta);
            System.out.println("Datos de la tarjeta guardados.");
        }

        System.out.println("Pago realizado con éxito. Disfrute su película y productos!");
    }
}
