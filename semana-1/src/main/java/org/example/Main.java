package org.example;

public class Main {
    public static void main(String[] args) {
        double numero1 = 10;
        double numero2 = 3;
        char operador = '+';

        double resultado;

        switch (operador) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                resultado = numero1 / numero2;
                break;
            default:
                System.out.println("Operador no válido");
                return;
        }

        System.out.println(numero1 + " " + operador + " " + numero2 + " = " + resultado);
    }
}