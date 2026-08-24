package org.example;

public class Pedido {
    private String producto;
    private double precio;

    public Pedido(String producto, double precio) {
        this.producto = producto;
        this.precio = precio;
    }

    public void mostrarDetalle() {
        System.out.println("- " + producto + ": $" + precio);
    }
}