package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ExemploDeTeste extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		return new ChromeDriver();
	}
	
	@Test
	public void teste_exemplo_1() {
		goTo("http://globo.com");
		fill("#Vendedor").with("01");
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Venda concluída.", findFirst("#vendaConcluida").getText());
					
	}	
}
