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

public class SimuladorIRPF {
	private static final String URL_PAGINA = "http://www.bb.com.br/portalbb/jsp/home/inst/inc/popSimuladorIR.jsp";
	private WebDriver driver;

	
	
	@Before
	public void inicializaBrowser() {
		driver = new ChromeDriver();
	}

	@After
	public void fecharBrowser() {
		driver.close();
	}

	@Dado("^que eu esteja na pagina do simulador$")
	public void que_eu_esteja_na_pagina_do_simulador() throws Throwable {
		driver.get(URL_PAGINA);
	}

	@Dado("^a data de aplicacao seja a data de \"([^\"]*)\"$")
	public void a_data_de_aplicacao_seja_a_data_de(String dataInicio) throws Throwable {
		driver.findElement(By.name("dataInicio")).sendKeys(dataInicio);
	}

	@Dado("^o tipo de investimento seja \"([^\"]*)\"$")
	public void o_tipo_de_investimento_seja(String tipo) throws Throwable {
	    driver.findElement(By.name("tipo")).sendKeys(tipo);
	}

	@Quando("^clicar no botao confirmar$")
	public void clicar_no_botao_confirmar() throws Throwable {
		driver.findElement(By.cssSelector("#conteudoCentral1 > div > input[type='image']")).click();

	}

	@Entao("^serao informadas a data da aplicacao$")
	public void serao_informadas_a_data_da_aplicacao() throws Throwable {
		String atual = driver.findElement(By.cssSelector("#conteudoCentral > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(1)")).getText();
		Assert.assertEquals("28/07/2017", atual);

	}

	@Entao("^as datas de resgate \"([^\"]*)\" e \"([^\"]*)\"$")
	public void as_datas_de_resgate_e(String dataResgateEsperadaParaAliquotaUm, String dataResgateEsperadaParaAliquotaDois) throws Throwable {
		String aliquotaUm = driver.findElement(By.cssSelector("#conteudoCentral > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
		String aliquotaDois = driver.findElement(By.cssSelector("#conteudoCentral > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(3) > td:nth-child(1)")).getText();
	
		Assert.assertTrue(aliquotaUm.contains(dataResgateEsperadaParaAliquotaUm));
		Assert.assertEquals(dataResgateEsperadaParaAliquotaDois, aliquotaDois);

		
	}


}
