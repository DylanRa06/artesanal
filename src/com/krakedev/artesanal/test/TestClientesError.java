package com.krakedev.artesanal.test;
import com.krakedev.artesanal.NegocioMejorado;
public class TestClientesError {
 // Reproduce el estado de los pasos 8-10: clientes sin inicializar.
 public static void main(String[] args){
  NegocioMejorado negocio=new NegocioMejorado();
  negocio.setClientes(null);
  negocio.registrarCliente("Dylan","1720000000");
 }
}
