/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventas;


import java.util.ArrayList;
import java.util.List;

public class Dulceria {

    private final List<Producto> productos;

    public Dulceria() {
        this.productos = new ArrayList<>();
        cargarBaseDeDatos();
    }

    private void cargarBaseDeDatos() {
        // Cargar los datos de los productos directamente en el código
        productos.add(new Producto("Refresco Grande", "75007614", 65, "Bebidas"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 50);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 110);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 52);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 200);

        productos.add(new Producto("Refresco Mediano", "75007615", 50, "Bebidas"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 80);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 110);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 5);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 200);

        productos.add(new Producto("ICEE", "75007616", 80, "Bebidas"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 0);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 80);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 44);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 100);

        productos.add(new Producto("Palomitas Grandes", "75007617", 75, "Botana"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 93);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 45);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 31);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 143);

        productos.add(new Producto("Palomitas Medianas", "75007618", 65, "Botana"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 72);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 13);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 65);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 112);

        productos.add(new Producto("Hotdog", "7S007619", 55, "Comida"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 37);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 25);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 80);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 99);

        productos.add(new Producto("Nachos", "75007620", 65, "Comida"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 63);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 80);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 305);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 210);

        productos.add(new Producto("Nerds", "75007621", 40, "Dulces"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 90);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 90);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 0);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 90);

        productos.add(new Producto("M&M’s", "7S007622", 43, "Dulces"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 130);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 45);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 3);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 0);

        productos.add(new Producto("Peluche Rob", "75007623", 250, "Galletas"));
        productos.get(productos.size() - 1).agregarStock("CINE-TICs CU", 5);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Universidad", 35);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Delta", 43);
        productos.get(productos.size() - 1).agregarStock("CINE-TICs Xochimilco", 89);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Producto> getProductosPorSucursal(String sucursal) {
        List<Producto> productosSucursal = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getStock(sucursal) > 0) {
                productosSucursal.add(producto);
            }
        }
        return productosSucursal;
    }
}
