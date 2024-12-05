
package Ventas;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompra {
    private List<Producto> productos;
    private List<Integer> cantidades;
    private int cantidadBoletosAdulto;
    private int cantidadBoletosNino;
    private double total;

    public CarritoDeCompra() {
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.cantidadBoletosAdulto = 0;
        this.cantidadBoletosNino = 0;
        this.total = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
        total += producto.getPrecio() * cantidad;
    }

    public void quitarProducto(int indice, int cantidad) {
        int cantidadActual = cantidades.get(indice);
        if (cantidad >= cantidadActual) {
            total -= productos.get(indice).getPrecio() * cantidadActual;
            productos.remove(indice);
            cantidades.remove(indice);
        } else {
            cantidades.set(indice, cantidadActual - cantidad);
            total -= productos.get(indice).getPrecio() * cantidad;
        }
    }

    public void agregarBoletos(int cantidadAdultos, int cantidadNinos) {
        this.cantidadBoletosAdulto += cantidadAdultos;
        this.cantidadBoletosNino += cantidadNinos;
        total += (cantidadAdultos * 80) + (cantidadNinos * 50);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public int getCantidadBoletosAdulto() {
        return cantidadBoletosAdulto;
    }

    public int getCantidadBoletosNino() {
        return cantidadBoletosNino;
    }

    public double getTotal() {
        return total;
    }

    public void mostrarCarrito() {
        System.out.println("Carrito de Compras:");
        if (cantidadBoletosAdulto > 0 || cantidadBoletosNino > 0) {
            System.out.println("Boletos:");
            if (cantidadBoletosAdulto > 0) {
                System.out.println("Adulto: " + cantidadBoletosAdulto + " - Precio: $80 - Subtotal: $" + (cantidadBoletosAdulto * 80));
            }
            if (cantidadBoletosNino > 0) {
                System.out.println("Niño: " + cantidadBoletosNino + " - Precio: $50 - Subtotal: $" + (cantidadBoletosNino * 50));
            }
        }
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            System.out.println("Producto: " + producto.getNombre() + " - Cantidad: " + cantidad + " - Precio: $" + producto.getPrecio() + " - Subtotal: $" + (producto.getPrecio() * cantidad));
        }
        System.out.println("Total de la compra: $" + total);
    }
}
