package br.com.k21;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CalculadoraInvestimento {
	private static final String URL_PAGINA = "http://www.bb.com.br/portalbb/jsp/home/inst/popupFormSimulador.jsp?id=2";
	private WebDriver driver;

	
	@Before
	public void inicializaBrowser() {
		driver = new ChromeDriver();
	}

	@After
	public void fecharBrowser() {
		driver.close();
	}

	@Dado("^que Estou na tela do Simulador de rendimento futuro$")
	public void que_Estou_na_tela_do_Simulador_de_rendimento_futuro() throws Throwable {
		
		driver.get(URL_PAGINA);
	}

	@Dado("^informo que pretendo atingir \"([^\"]*)\" de reais$")
	public void informo_que_pretendo_atingir_de_reais(String meta) throws Throwable {
		driver.findElement(By.name("montanteTotal")).sendKeys(meta);
		
	}

	@Dado("^pretendo investir \"([^\"]*)\" reais por mes$")
	public void pretendo_investir_reais_por_mes(String investimento) throws Throwable {
		driver.findElement(By.name("valorMensal")).sendKeys(investimento);
	}

	@Dado("^esperado a rentabilidade mensal de \"([^\"]*)\" % ao mes$")
	public void esperado_a_rentabilidade_mensal_de_ao_mes(String rendimento) throws Throwable {
		driver.findElement(By.name("rendimentoMensal")).sendKeys(rendimento);
	}

	@Dado("^disponho de \"([^\"]*)\" reais para aplicar$")
	public void disponho_de_reais_para_aplicar(String valorInicial) throws Throwable {
		driver.findElement(By.name("valorInicial")).sendKeys(valorInicial);
	}

	@Quando("^clicar no botao OK$")
	public void clicar_no_botao() throws Throwable {
		driver.findElement(By.id("ok")).click();
	}
	

	@Entao("^sera informado que o valor desejado sera atingido em aproximadamente \"([^\"]*)\"\\.$")
	public void sera_informado_que_o_valor_desejado_sera_atingido_em_aproximadamente(String mensagemEsperada) throws Throwable {
		String atual = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/b")).getText();
		Assert.assertTrue(atual.contains(mensagemEsperada));
	}
	
	@Entao("^devo ficar na mesma pagina$")
	public void devo_ficar_na_mesma_pagina() throws Throwable {
	    Assert.assertEquals(URL_PAGINA,driver.getCurrentUrl());
	}

	@Entao("^a mensagem de erro \"([^\"]*)\" deve ser exibida$")
	public void a_mensagem_de_erro_deve_ser_exibida(String mensagemErro) throws Throwable {
        Assert.assertEquals(mensagemErro,driver.findElement(By.id("mensagemErro")).getText());
	}

}
