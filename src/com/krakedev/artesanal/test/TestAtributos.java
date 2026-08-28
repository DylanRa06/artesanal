package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

    public static void main(String[] args) {

        Maquina rubia = new Maquina(
                "M001",
                "Pilsener",
                "Cerveza rubia",
                0.02,
                8000
        );

        System.out.println("Código: " + rubia.getCodigo());
        System.out.println("Nombre: " + rubia.getNombre());
        System.out.println("Descripción: " + rubia.getDescripcion());
        System.out.println("Precio por ml: " + rubia.getPrecioPorMl());
        System.out.println("Capacidad máxima: " + rubia.getCapacidadMaxima());
        System.out.println("Cantidad actual: " + rubia.getCantidadActual());
    }
}