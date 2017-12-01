package br.com.k21.montador;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import br.com.k21.Cliente;

public class ImportadorArquivoCliente {


	public List<Cliente> montaClientesLendoArquivo(String nomeArquivo) throws IOException {
		List<Cliente> listaClientes = new ArrayList<Cliente>();

		Reader in = new FileReader(nomeArquivo);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
		for (CSVRecord record : records) {

			Cliente cliente = new Cliente();
			cliente.setId(Long.valueOf(record.get(0)));
			cliente.setPrimeiroNome(record.get(1));
			cliente.setSobrenome(record.get(2));
			cliente.setCpf(record.get(3));

			listaClientes.add(cliente);
		}

		return listaClientes;
	}
}
