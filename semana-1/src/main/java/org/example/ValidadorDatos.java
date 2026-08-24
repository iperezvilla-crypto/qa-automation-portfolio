package org.example;

public class ValidadorDatos {
    public static void main(String[] args) {
        String email = "ismael@ejemplo.com";
        int edad = 28;

        boolean emailValido = email.contains("@") && email.contains(".");
        boolean edadValida = edad >= 18 && edad <= 99;

        System.out.println("Email: " + email);
        System.out.println("¿Es válido? " + emailValido);

        System.out.println("Edad: " + edad);
        System.out.println("¿Es válida? " + edadValida);
    }
}