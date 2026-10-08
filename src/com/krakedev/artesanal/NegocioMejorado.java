package com.krakedev.artesanal;
import java.util.ArrayList;
public class NegocioMejorado {
 private ArrayList<Maquina> maquinas=new ArrayList<Maquina>();
 private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
 private int ultimoCodigo;
 public ArrayList<Maquina> getMaquinas(){return maquinas;}
 public void setMaquinas(ArrayList<Maquina> valor){maquinas=valor;}
 public ArrayList<Cliente> getClientes(){return clientes;}
 public void setClientes(ArrayList<Cliente> valor){clientes=valor;}
 public String generarCodigo(){return "M-"+((int)(Math.random()*100)+1);}
 public boolean agregarMaquina(String nombre,String descripcion,double precioPorML){
  String codigo=generarCodigo();
  if(recuperarMaquina(codigo)!=null)return false;
  Maquina maquina=new Maquina(codigo,nombre,descripcion,precioPorML, 8000);
  maquinas.add(maquina);return true;
 }
 public void cargarMaquinas(){for(int i=0;i<maquinas.size();i++)maquinas.get(i).llenarMaquina();}
 public Maquina recuperarMaquina(String codigo){
  for(int i=0;i<maquinas.size();i++)if(maquinas.get(i).getCodigo().equals(codigo))return maquinas.get(i);
  return null;
 }
 // Base reconstruida: C-1, C-2...; no se dispone de la clase Negocio original.
 public Cliente registrarCliente(String nombre,String cedula){
  Cliente cliente=new Cliente("C-"+(ultimoCodigo+1),nombre,cedula);
  clientes.add(cliente);ultimoCodigo++;return cliente;
 }
 public Cliente buscarClientePorCedula(String cedula){
  for(int i=0;i<clientes.size();i++)if(clientes.get(i).getCedula().equals(cedula))return clientes.get(i);
  return null;
 }
 public Cliente buscarClientePorCodigo(String codigo){
  for(int i=0;i<clientes.size();i++)if(clientes.get(i).getCodigo().equals(codigo))return clientes.get(i);
  return null;
 }
 public double consumirCerveza(String codigoCliente,String codigoMaquina,double cantidad){
  Maquina maquina=recuperarMaquina(codigoMaquina);
  Cliente cliente=buscarClientePorCodigo(codigoCliente);
  if(maquina==null||cliente==null)throw new IllegalArgumentException("Cliente o maquina inexistente");
  if(!Double.isFinite(cantidad)||cantidad<=0)throw new IllegalArgumentException("Cantidad invalida");
  double valor=maquina.servirCerveza(cantidad);
  registrarConsumo(cliente,valor);return valor;
 }
 public void registrarConsumo(Cliente cliente,double valor){cliente.setTotalConsumido(cliente.getTotalConsumido()+valor);}
 public double consultarValorVendido(){
  double total=0;for(int i=0;i<clientes.size();i++)total+=clientes.get(i).getTotalConsumido();return total;
 }
}
