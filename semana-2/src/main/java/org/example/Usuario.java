package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void mostrarPedidos() {
        System.out.println(nombre + " tiene " + pedidos.size() + " pedido(s):");
        for (Pedido p : pedidos) {
            p.mostrarDetalle();
        }
    }
}