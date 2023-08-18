#language:pt
  Funcionalidade: Buscando Mensagem Ola Mundo
    Cenario: Buscar mensagem Ola Mundo com Sucesso
      Quando que realizo a requisicao de buscar  mensagem
      Entao o httpStatus deve ser 200
      E a mensagem deve ser "OLA_MUNDO_MENSAGEM"