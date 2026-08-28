package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

    @Test
    public void testRecargaExitosa() {

        Maquina negra = new Maquina(
                "M002",
                "Club",
                "cerveza fría",
                0.03,
                8000
        );

        boolean resultado = negra.recargarCerveza(7000);

        assertTrue(resultado);
        assertEquals(7000, negra.getCantidadActual(), 0.0001);
    }

    @Test
    public void testRecargaFallidaPorDesborde() {

        Maquina negra = new Maquina(
                "M002",
                "Club",
                "cerveza fría",
                0.03,
                8000
        );

        negra.recargarCerveza(7000);

        boolean resultado = negra.recargarCerveza(1000);

        assertFalse(resultado);
        assertEquals(7000, negra.getCantidadActual(), 0.0001);
    }
}