package br.com.k21;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private VendaRepository vendaRepository;
	
	@Before
	public void setup () {
		vendaRepository = mock(VendaRepository.class);
	}
	
	@Test public void
	deve_retornar_zero_royalties_quando_nao_houver_vendas_no_mes() {
		int mes = 3;
		int ano = 18; 
		Double zero = new Double(0);
		 
		when(vendaRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(new ArrayList<Venda>());
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(vendaRepository);
		Double royalties = calculadoraRoyalties.calculaRoyaltiesAnoMes(ano, mes);
		
		Assert.assertEquals(zero, royalties);
	}
	
	@Test public void
	deve_retornar_royalties_quando_houver_uma_venda_no_mes() {
		int mes = 2;
		int ano = 18;
		Double royaltiesEsperado = new Double(950);
		
		List<Venda> vendas = new ArrayList<Venda>();
		Venda venda = new Venda(1, 1, mes, ano, 5000);
		vendas.add(venda);
		
		when(vendaRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(vendaRepository);
		Double royaltiesCalculado = calculadoraRoyalties.calculaRoyaltiesAnoMes(ano, mes);
		
		Assert.assertEquals(royaltiesEsperado, royaltiesCalculado);
	}
	
	@Test public void
	deve_retornar_royalties_quando_houver_mais_de_uma_venda_no_mes() {
		int mes = 1;
		int ano = 17;
		Double royaltiesEsperado = new Double(2258);
		
		List<Venda> vendas = new ArrayList<Venda>();
		Venda venda1 = new Venda(1, 1, mes, ano, 1000);
		vendas.add(venda1);
		
		Venda venda2 = new Venda(1, 1, mes, ano, 11000);
		vendas.add(venda2);
		
		when(vendaRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(vendaRepository);
		Double royaltiesCalculado = calculadoraRoyalties.calculaRoyaltiesAnoMes(ano, mes);
		
		Assert.assertEquals(royaltiesEsperado, royaltiesCalculado);
	}
}
