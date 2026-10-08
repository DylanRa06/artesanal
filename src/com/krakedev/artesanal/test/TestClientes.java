package com.krakedev.artesanal.test;
import com.krakedev.artesanal.NegocioMejorado;
public class TestClientes {
 public static void main(String[] args){
  NegocioMejorado negocio=new NegocioMejorado();
  negocio.registrarCliente("Dylan","1720000000");
  System.out.println("Clientes registrados: "+negocio.getClientes().size());
 }
}
