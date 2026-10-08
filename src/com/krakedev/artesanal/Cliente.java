package com.krakedev.artesanal;
public class Cliente {
 private String codigo, nombre, cedula;
 private double totalConsumido;
 public Cliente(String codigo,String nombre,String cedula){this.codigo=codigo;this.nombre=nombre;this.cedula=cedula;}
 public String getCodigo(){return codigo;}
 public String getNombre(){return nombre;}
 public String getCedula(){return cedula;}
 public double getTotalConsumido(){return totalConsumido;}
 public void setTotalConsumido(double valor){totalConsumido=valor;}
}
