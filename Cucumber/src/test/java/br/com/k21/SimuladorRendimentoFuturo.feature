	# language: pt
Funcionalidade: Simulador de rendimento futuro
    Eu, enquanto cliente, gostaria de saber quantos meses serao necessarios para atingir minha meta
    
Cenario: Testar quanto tempo leva para se tornar milionario
    Dado que Estou na tela do Simulador de rendimento futuro
    E informo que pretendo atingir "1000000,00" de reais
    E pretendo investir "1000,00" reais por mes
    E esperado a rentabilidade mensal de "1,00" % ao mes
    E disponho de "10000,00" reais para aplicar
    Quando clicar no botao OK
 	Entao sera informado que o valor desejado sera atingido em aproximadamente "231 meses".
 	
 Cenario: Testar quando a rentabilidade mensal informada for invalida
    Dado que Estou na tela do Simulador de rendimento futuro
    E informo que pretendo atingir "1000000,00" de reais
    E pretendo investir "1000,00" reais por mes
    E esperado a rentabilidade mensal de "0" % ao mes
    E disponho de "10000,00" reais para aplicar
    Quando clicar no botao OK
 	Entao devo ficar na mesma pagina
 	E a mensagem de erro "Informe uma rentabilidade valida" deve ser exibida