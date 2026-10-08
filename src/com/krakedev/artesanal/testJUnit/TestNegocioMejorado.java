package com.krakedev.artesanal.testJUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.krakedev.artesanal.*;
public class TestNegocioMejorado {
 // Fuerza la misma clave para probar duplicados sin depender del azar.
 static class Fijo extends NegocioMejorado { public String generarCodigo(){return "M-25";} }
 @Test public void codigoEnRango(){NegocioMejorado n=new NegocioMejorado(); for(int i=0;i<1000;i++){String c=n.generarCodigo();assertTrue(c.matches("M-[0-9]+"));int v=Integer.parseInt(c.substring(2));assertTrue(v>=1&&v<=100);}}
 @Test public void agregarMaquina(){NegocioMejorado n=new Fijo();assertTrue(n.agregarMaquina("IPA","Clara",0.01));Maquina m=n.recuperarMaquina("M-25");assertEquals("IPA",m.getNombre());assertEquals("Clara",m.getDescripcion());assertEquals(0.01,m.getPrecioPorMl(),0.00001);}
 @Test public void duplicadoNoAgrega(){NegocioMejorado n=new Fijo();assertTrue(n.agregarMaquina("IPA","Clara",0.01));assertFalse(n.agregarMaquina("Otra","Otra",0.02));assertEquals(1,n.getMaquinas().size());assertEquals("IPA",n.recuperarMaquina("M-25").getNombre());}
 @Test public void recuperarInexistente(){assertNull(new NegocioMejorado().recuperarMaquina("M-100"));}
 @Test public void cargarTodas(){NegocioMejorado n=new NegocioMejorado();n.getMaquinas().add(new Maquina("M-1","IPA","Clara",0.01,8000));n.getMaquinas().add(new Maquina("M-2","Porter","Oscura",0.02,8000));n.cargarMaquinas();for(Maquina m:n.getMaquinas())assertEquals(7800,m.getCantidadActual(),0.00001);}
 @Test public void clientesSecuenciales(){NegocioMejorado n=new NegocioMejorado();Cliente a=n.registrarCliente("Ana","1");Cliente b=n.registrarCliente("Juan","2");assertEquals("C-1",a.getCodigo());assertEquals("C-2",b.getCodigo());assertEquals(2,n.getClientes().size());}
 @Test public void buscarCedula(){NegocioMejorado n=new NegocioMejorado();Cliente a=n.registrarCliente("Ana","1");assertSame(a,n.buscarClientePorCedula("1"));assertNull(n.buscarClientePorCedula("2"));}
 @Test public void buscarCodigo(){NegocioMejorado n=new NegocioMejorado();Cliente a=n.registrarCliente("Ana","1");assertSame(a,n.buscarClientePorCodigo("C-1"));assertNull(n.buscarClientePorCodigo("C-2"));}
 @Test public void errorSinInicializar(){NegocioMejorado n=new NegocioMejorado();n.setClientes(null);assertThrows(NullPointerException.class,()->n.registrarCliente("Ana","1"));}
 @Test public void consumoAcumula(){NegocioMejorado n=new Fijo();n.agregarMaquina("IPA","Clara",0.01);n.cargarMaquinas();Cliente a=n.registrarCliente("Ana","1");assertEquals(5,n.consumirCerveza(a.getCodigo(),"M-25",500),0.00001);assertEquals(2.5,n.consumirCerveza(a.getCodigo(),"M-25",250),0.00001);assertEquals(7.5,a.getTotalConsumido(),0.00001);assertEquals(7050,n.recuperarMaquina("M-25").getCantidadActual(),0.00001);}
 @Test public void ventasTodosClientes(){NegocioMejorado n=new Fijo();n.agregarMaquina("IPA","Clara",0.01);n.cargarMaquinas();Cliente a=n.registrarCliente("Ana","1");Cliente b=n.registrarCliente("Juan","2");n.consumirCerveza(a.getCodigo(),"M-25",500);n.consumirCerveza(b.getCodigo(),"M-25",200);assertEquals(7,n.consultarValorVendido(),0.00001);assertEquals(5,a.getTotalConsumido(),0.00001);assertEquals(2,b.getTotalConsumido(),0.00001);}
 @Test public void sinVentas(){assertEquals(0,new NegocioMejorado().consultarValorVendido(),0.00001);}
 @Test public void sinStockNoModifica(){NegocioMejorado n=new Fijo();n.agregarMaquina("IPA","Clara",0.01);Cliente a=n.registrarCliente("Ana","1");assertEquals(0,n.consumirCerveza(a.getCodigo(),"M-25",100),0.00001);assertEquals(0,a.getTotalConsumido(),0.00001);assertEquals(0,n.recuperarMaquina("M-25").getCantidadActual(),0.00001);}
 @Test public void clienteInexistenteNoModifica(){NegocioMejorado n=new Fijo();n.agregarMaquina("IPA","Clara",0.01);n.cargarMaquinas();assertThrows(IllegalArgumentException.class,()->n.consumirCerveza("C-99","M-25",500));assertEquals(7800,n.recuperarMaquina("M-25").getCantidadActual(),0.00001);}
 @Test public void cantidadInvalidaNoModifica(){NegocioMejorado n=new Fijo();n.agregarMaquina("IPA","Clara",0.01);n.cargarMaquinas();Cliente a=n.registrarCliente("Ana","1");assertThrows(IllegalArgumentException.class,()->n.consumirCerveza(a.getCodigo(),"M-25",-1));assertEquals(7800,n.recuperarMaquina("M-25").getCantidadActual(),0.00001);assertEquals(0,a.getTotalConsumido(),0.00001);}
}
