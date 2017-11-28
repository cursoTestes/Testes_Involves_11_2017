package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaRepository vendaRepository = new VendaRepository();
	private CalculadoraComissao calculadoraComissao = new CalculadoraComissao();;

	public CalculadoraRoyalties(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}

	public Double calculaRoyaltiesAnoMes(int ano, int mes) {
		List<Venda> vendas = vendaRepository.obterVendasPorMesEAno(ano, mes);
		
		Double totalFaturamento = 0d;
		Double totalComissao = 0d;
		
		for (Venda venda : vendas) {
			totalFaturamento = totalFaturamento + venda.getValor();
			totalComissao = totalComissao + calculadoraComissao.calcularComissao(venda.getValor());
		}
		
		Double faturamentoLiquido = totalFaturamento - totalComissao;
		
		return faturamentoLiquido * 0.2;
	}

}
