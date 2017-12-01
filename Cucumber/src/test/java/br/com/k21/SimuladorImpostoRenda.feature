	# language: pt
Funcionalidade: Simulador de IRPF
    Eu, enquanto cliente, gostaria de saber qual aliquota de cada um dos meus tipos de investimento
    
Cenario: Investimento curto prazo com data de 28/07/2017
    Dado que eu esteja na pagina do simulador 
    E a data de aplicacao seja a data de "28/07/2017" 
	E o tipo de investimento seja "Fundos de Curto Prazo"
    Quando clicar no botao confirmar 
 	Entao serao informadas a data da aplicacao
 	E as datas de resgate "24/01/2018" e "A partir de 25/01/2018"
 	
Esquema do Cenario:      
    Dado que eu esteja na pagina do simulador 
    E a data de aplicacao seja a data de <data> 
	E o tipo de investimento seja <tipo_investimento>
    Quando clicar no botao confirmar 
 	Entao serao informadas a data da aplicacao
 	E sera exibida a mensagem <msg_retorno>
 	Exemplos: 
      | data   | tipo_investimento | msg_retorno |
      | 15/06/1983   | tipo a | texto da mensagem de retorno |
      | 15/06/1983   | tipo a | texto da mensagem de retorno |
      
       	
Cenario: Investimento em Fundos de acoes
    Dado que eu esteja na pagina do simulador 
    E a data de aplicacao seja a data de "28/07/2017" 
	E o tipo de investimento seja "Fundos de Ações"
    Quando clicar no botao confirmar 
 	Entao serao informadas a data da aplicacao
 	E sera exibida a mensagem "De acordo com a Lei nº 11.033, de 21 de dezembro de 2004, os fundos e clubes de investimentos em ações terão os rendimentos tributados, exclusivamente, na data do resgate das quotas, a alíquota é de 15% (quinze por cento)."
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	