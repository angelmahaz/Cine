/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventas;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TicketVirtual {
    private String idCompra;
    private String fechaCompra;
    private String sucursal;
    private CarritoDeCompra carrito;

    public TicketVirtual(String sucursal, CarritoDeCompra carrito) {
        this.idCompra = UUID.randomUUID().toString();
        this.fechaCompra = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        this.sucursal = sucursal;
        this.carrito = carrito;
    }

    public void mostrarTicket() {
        System.out.println("Ticket Virtual");
        System.out.println("ID de Compra: " + idCompra);
        System.out.println("Fecha de Compra: " + fechaCompra);
        System.out.println("Sucursal: " + sucursal);
        carrito.mostrarCarrito();
    }

    public void guardarTicketEnArchivo() {
        try (FileWriter writer = new FileWriter("ticket_" + idCompra + ".txt")) {
            writer.write("Ticket Virtual\n");
            writer.write("ID de Compra: " + idCompra + "\n");
            writer.write("Fecha de Compra: " + fechaCompra + "\n");
            writer.write("Sucursal: " + sucursal + "\n");
            writer.write("Carrito de Compras:\n");
            if (carrito.getCantidadBoletosAdulto() > 0 || carrito.getCantidadBoletosNino() > 0) {
                writer.write("Boletos:\n");
                if (carrito.getCantidadBoletosAdulto() > 0) {
                    writer.write("Adulto: " + carrito.getCantidadBoletosAdulto() + " - Precio: $80 - Subtotal: $" + (carrito.getCantidadBoletosAdulto() * 80) + "\n");
                }
                if (carrito.getCantidadBoletosNino() > 0) {
                    writer.write("Niño: " + carrito.getCantidadBoletosNino() + " - Precio: $50 - Subtotal: $" + (carrito.getCantidadBoletosNino() * 50) + "\n");
                }
            }
            for (int i = 0; i < carrito.getProductos().size(); i++) {
                Producto producto = carrito.getProductos().get(i);
                int cantidad = carrito.getCantidades().get(i);
                writer.write("Producto: " + producto.getNombre() + " - Cantidad: " + cantidad + " - Precio: $" + producto.getPrecio() + " - Subtotal: $" + (producto.getPrecio() * cantidad) + "\n");
            }
            writer.write("Total de la compra: $" + carrito.getTotal() + "\n");
            System.out.println("Ticket guardado en archivo: ticket_" + idCompra + ".txt");
        } catch (IOException e) {
            System.err.println("Error al guardar el ticket en archivo: " + e.getMessage());
        }
    }

    public String getIdCompra() {
        return idCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public String getSucursal() {
        return sucursal;
    }

    public CarritoDeCompra getCarrito() {
        return carrito;
    }
}