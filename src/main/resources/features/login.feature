# language: pt

  Funcionalidade: Apenas usuarios cadastradis podem ser logar

    Cenario: Um usuario valido consegue se logar
      Dado o usuario valido
      Quando realiza login
      Entao e redirecionado para a pagina de leiloes


    Cenario: Um usuario invalidado nao consegue se logar
      Dado o usuario invalido
      Quando tenta logar
      Entao continua na pagina de login

