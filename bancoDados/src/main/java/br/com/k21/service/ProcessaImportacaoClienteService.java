package br.com.k21.service;

import java.io.IOException;
import java.util.List;

import br.com.k21.Cliente;
import br.com.k21.dao.ClienteDAO;
import br.com.k21.montador.ImportadorArquivoCliente;

public class ProcessaImportacaoClienteService {
	private static final String ARQUIVO_HARDCODED_PARA_LEITURA = "C:\\k21\\cliente.csv";

	
	private ImportadorArquivoCliente importador = new ImportadorArquivoCliente();
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	
	public void processaImportacaoArquivoClientes() throws IOException
	{
		List<Cliente> listaClientes = importador.montaClientesLendoArquivo(ARQUIVO_HARDCODED_PARA_LEITURA);
		
		clienteDAO.salvarClientes(listaClientes);
	}
	
}
