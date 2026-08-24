package org.example;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Ismael");
        usuario.agregarPedido(new Pedido("Teclado", 25.50));
        usuario.agregarPedido(new Pedido("Mouse", 15.00));

        usuario.mostrarPedidos();

        UsuarioPremium premium = new UsuarioPremium("Valentina");
        premium.agregarPedido(new Pedido("Monitor", 180.00));
        premium.mostrarPedidos();
        premium.aplicarDescuento();
    }
}