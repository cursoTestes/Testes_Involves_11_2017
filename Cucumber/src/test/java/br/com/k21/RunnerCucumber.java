package br.com.k21;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(cucumber.api.junit.Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"})
public class RunnerCucumber {

}
