/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventas;

import java.util.HashMap;
import java.util.Map;

public class Producto {
    private String nombre;
    private String codigo;
    private int precio;
    private String categoria;
    private Map<String, Integer> stockPorSucursal;

    public Producto(String nombre, String codigo, int precio, String categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.stockPorSucursal = new HashMap<>();
    }

    public void agregarStock(String sucursal, int stock) {
        stockPorSucursal.put(sucursal, stock);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock(String sucursal) {
        return stockPorSucursal.getOrDefault(sucursal, 0);
    }

    public Map<String, Integer> getStockPorSucursal() {
        return stockPorSucursal;
    }
}