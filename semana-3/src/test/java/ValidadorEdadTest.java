package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorEdadTest {

    @Test
    public void edadValidaNoTiraExcepcion() {
        ValidadorEdad validador = new ValidadorEdad();
        assertDoesNotThrow(() -> validador.validar(28));
    }

    @Test
    public void edadInvalidaTiraExcepcion() {
        ValidadorEdad validador = new ValidadorEdad();
        assertThrows(EdadInvalidaException.class, () -> validador.validar(-5));
    }
}