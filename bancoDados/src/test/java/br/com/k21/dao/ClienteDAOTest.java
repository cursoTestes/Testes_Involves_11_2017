package br.com.k21.dao;

import java.util.List;

import org.junit.Test;

import br.com.k21.Cliente;
import br.com.k21.infra.BaseDBTest;

public class ClienteDAOTest extends BaseDBTest {

	@Test
	public void testConsultarCliente() {

		ClienteDAO.setEntityManager(emf.createEntityManager());
		List<Cliente> lista = ClienteDAO.findAll();
		assertEquals(0, lista.size());

	}

}
