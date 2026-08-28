package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

    public static void main(String[] args) {

        Maquina rubia = new Maquina(
                "M001",
                "Pilsener",
                "cerveza",
                0.02,
                8000
        );

        rubia.llenarMaquina();

        System.out.println("Código: " + rubia.getCodigo());
        System.out.println("Cantidad actual: " + rubia.getCantidadActual());
    }
}