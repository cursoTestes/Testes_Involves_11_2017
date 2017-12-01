package br.com.k21.service;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import br.com.k21.Cliente;
import br.com.k21.dao.ClienteDAO;
import br.com.k21.infra.BaseDBTest;

public class ProcessaImportacaoClienteServiceTest extends BaseDBTest {

	@Test
	public void testVerificaPersistenciaClientesImportados() throws IOException {
		ClienteDAO.setEntityManager(emf.createEntityManager());
		
		ProcessaImportacaoClienteService service = new ProcessaImportacaoClienteService();
		
		int tamanhoListaEsperada =4;
		
		// act
		service.processaImportacaoArquivoClientes();
		
		// asserts
		List<Cliente> listaTodaBaseClientes = ClienteDAO.findAll();
		
		assertEquals(tamanhoListaEsperada, listaTodaBaseClientes.size());
		
	}
	

}
