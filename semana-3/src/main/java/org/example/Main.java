package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "resultado_test.txt";

        // Escribir un archivo
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write("Test ejecutado: edadValidaNoTiraExcepcion -> PASSED\n");
            writer.write("Test ejecutado: edadInvalidaTiraExcepcion -> PASSED\n");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        // Leer el mismo archivo
        try {
            String contenido = Files.readString(Path.of(rutaArchivo));
            System.out.println("Contenido del archivo:");
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        String resumenJson = "{\"testsPasados\": 2, \"testsFallidos\": 0, \"estado\": \"OK\"}";
        System.out.println("Resumen en formato JSON: " + resumenJson);
    }
}