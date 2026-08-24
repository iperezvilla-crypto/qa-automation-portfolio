package org.example;

public class UsuarioPremium extends Usuario {

    public UsuarioPremium(String nombre) {
        super(nombre);
    }

    public void aplicarDescuento() {
        System.out.println("Como sos Premium, tenés 10% de descuento en tu próxima compra");
    }
}