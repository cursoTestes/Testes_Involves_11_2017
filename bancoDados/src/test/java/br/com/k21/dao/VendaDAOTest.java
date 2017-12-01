package br.com.k21.dao;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.com.k21.Vendedor;
import br.com.k21.dao.VendaDAO;
import br.com.k21.dao.VendedorDAO;
import br.com.k21.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testTotal_Para_Vendedor_Inexistente() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 99;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 0.0;
		
		// act
		try {
			VendaDAO.setEntityManager(emf.createEntityManager());
			resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
			Assert.fail("Não deveria encontrar venda para o vendedor não existente.");
		} catch (Exception e) {
			Assert.assertEquals("Vendedor nao encontrado", e.getMessage());
		}
	}
	
	@Test
	public void testTotal_Para_Vendedor_Sem_Venda() throws Exception {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 1;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotal_Para_Vendedor_Sem_Venda_Em_2012() throws Exception {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2012;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotal_Para_Vendedor_Com_Uma_Venda_Em_2011() throws Exception {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotal_Para_Vendedor_Com_Mais_De_Uma_Venda_Em_2011() throws Exception {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 200;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotal_Para_Vendedor_Com_Mais_Venda_Decimal() throws Exception {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 5;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2012;
		double resultado;
		double esperado = 100.5;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotal_Para_Vendedor_Com_Venda_Compartilhada() throws Exception {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 8;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2013;
		double resultado;
		double esperado = 900;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}
}
