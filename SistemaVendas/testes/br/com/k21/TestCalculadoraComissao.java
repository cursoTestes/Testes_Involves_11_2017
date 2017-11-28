package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculadoraComissao {

	CalculadoraComissao calculadora = new CalculadoraComissao();
	
	@Test
	public void calcular_comissao_5_porcento_quando_venda_menor_que_10k() {
		Double entrada = 500d;
		Double comissaoEsperada = 25d;

		Double resultadoCalculo = calculadora.calcularComissao(entrada);

		assertEquals(comissaoEsperada, resultadoCalculo);
	}

	@Test
	public void calcular_comissao_5_porcento_de_uma_venda_de_1_centavo() {
		Double entrada = 0.01d;
		Double comissaoEsperada = 0.00d;

		Double resultadoCalculo = calculadora.calcularComissao(entrada);
		
		assertEquals(comissaoEsperada, resultadoCalculo);
	}

	@Test
	public void calcular_comissao_5_porcento_de_uma_venda_de_10k() {
		Double entrada = 10000d;
		Double comissaoEsperada = 500d;

		Double resultadoCalculo = calculadora.calcularComissao(entrada);
		
		assertEquals(comissaoEsperada, resultadoCalculo);
	}
}
