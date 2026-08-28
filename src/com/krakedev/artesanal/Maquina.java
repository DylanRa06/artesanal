package com.krakedev.artesanal;

public class Maquina {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precioPorMl;
    private double capacidadMaxima;
    private double cantidadActual;

    public Maquina(String codigo, String nombre, String descripcion,
            double precioPorMl, double capacidadMaxima) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorMl = precioPorMl;
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioPorMl() {
        return precioPorMl;
    }

    public void setPrecioPorMl(double precioPorMl) {
        this.precioPorMl = precioPorMl;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void imprimir() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio por ml: " + precioPorMl);
        System.out.println("Capacidad máxima: " + capacidadMaxima);
        System.out.println("Cantidad actual: " + cantidadActual);
    }

    public void llenarMaquina() {
        this.cantidadActual = this.capacidadMaxima - 200;
    }

    public boolean recargarCerveza(double cantidad) {

        double limitePermitido;
        limitePermitido = capacidadMaxima - 200;

        if (cantidadActual + cantidad <= limitePermitido) {
            cantidadActual = cantidadActual + cantidad;
            return true;
        } else {
            return false;
        }
    }

    public double servirCerveza(double cantidad) {

        if (cantidadActual >= cantidad) {

            cantidadActual = cantidadActual - cantidad;

            double valor;
            valor = cantidad * precioPorMl;

            return valor;

        } else {
            return 0;
        }
    }
}