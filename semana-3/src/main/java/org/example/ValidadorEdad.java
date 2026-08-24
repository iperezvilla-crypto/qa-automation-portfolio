package org.example;

public class ValidadorEdad {
    public void validar(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad " + edad + " no es válida");
        }
        System.out.println("Edad " + edad + " es válida");
    }
}