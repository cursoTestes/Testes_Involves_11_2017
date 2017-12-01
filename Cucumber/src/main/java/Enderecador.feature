# language: pt
Funcionalidade: Enderecador 
    Eu, enquanto cliente S.A., gostaria de gerar etiquetas promocionais
 
Cenario: Gerar etiqueta para apenas um destinatario
    Dado que estou na tela do enderecador
    Quando informo o cep do remetente como "03020-030"
    E nome do remetente como "Dina S.A."
    E promocao do remetente  como "promo"
    E numero do remetente como "134"
    
    E informo o cep do destinatario como "03320-030"
    E nome do destinatario como "CLIENTE S.A."
    E promocao do destinatario  como "promo"
    E numero do destinatario como "333"
    E clico em gerar etiqueta
    Entao deve aparecer o pdf da etiqueta
    
    
Cenario: Gerar etiqueta para apenas dois destinatarios
    Dado que estou na tela do enderecador
    Quando informo o cep do remetente como "03020-030"
    E nome do remetente como "Dina S.A."
    E promocao do remetente  como "promo"
    E numero do remetente como "134"
    
    E informo o cep do destinatario como "03320-030"
    E nome do destinatario como "CLIENTE S.A."
    E promocao do destinatario  como "promo"
    E numero do destinatario como "333"
    E clico em gerar etiqueta
    Entao deve aparecer o pdf da etiqueta
    
    


    