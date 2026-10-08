package com.krakedev.artesanal.test;
import com.krakedev.artesanal.*;
public class TestIntegracion {
 public static void main(String[] args){
  NegocioMejorado n=new NegocioMejorado();
  if(!n.agregarMaquina("IPA","Artesanal",0.01))throw new IllegalStateException();
  n.cargarMaquinas();Cliente c=n.registrarCliente("Dylan","1720000000");
  String codigo=n.getMaquinas().get(0).getCodigo();
  n.consumirCerveza(c.getCodigo(),codigo,500);n.consumirCerveza(c.getCodigo(),codigo,250);
  System.out.println("Total cliente: "+c.getTotalConsumido());
  System.out.println("ML restantes: "+n.recuperarMaquina(codigo).getCantidadActual());
  System.out.println("Total vendido: "+n.consultarValorVendido());
 }
}
