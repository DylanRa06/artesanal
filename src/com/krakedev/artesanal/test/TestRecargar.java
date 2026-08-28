package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

    public static void main(String[] args) {

        Maquina negra = new Maquina(
                "M002",
                "Club",
                "cerveza fría",
                0.03,
                8000
        );

        boolean resultado1 = negra.recargarCerveza(7000);

        System.out.println("Primera recarga: " + resultado1);
        System.out.println("Cantidad actual: " + negra.getCantidadActual());

        boolean resultado2 = negra.recargarCerveza(1000);

        System.out.println("Segunda recarga: " + resultado2);
        System.out.println("Cantidad actual: " + negra.getCantidadActual());
    }
}