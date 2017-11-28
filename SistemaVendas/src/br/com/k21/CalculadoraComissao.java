package br.com.k21;

public class CalculadoraComissao {

	private static final double VALOR_MINIMO_COMISSAO = 0d;
	private static final double VALOR_MINIMO_VENDA = 0.01;
	private static final double COMISSAO_5_PORCENTO = 0.05d;

	public Double calcularComissao(Double totalVenda) {
		if(totalVenda <= VALOR_MINIMO_VENDA)  {
			return VALOR_MINIMO_COMISSAO;
		}
		return totalVenda * COMISSAO_5_PORCENTO;
	}
}
