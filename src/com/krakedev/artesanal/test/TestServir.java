package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

    public static void main(String[] args) {

        Maquina rubia = new Maquina(
                "M001",
                "Pilsener",
                "cerveza",
                0.02,
                8000
        );

        rubia.recargarCerveza(3000);

        double valor = rubia.servirCerveza(500);

        System.out.println("Valor: " + valor);
        System.out.println("Cantidad restante: " + rubia.getCantidadActual());
    }
}