Feature: Pegar Status do servidor

  Scenario: Buscar filme com sucesso
    When faco uma requisicao para a url de filme
    Then valido se a resposta

  Scenario: Buscar um filme pelo código
    When faco uma requisicao para a url de filme passando o código
    Then valido a resposta de um filme

  Scenario: Deletar um filme com sucesso
    When faco uma requisicao para deletar um filme
    Then valido se o filme foi deletado

  @criar
  Scenario: Criar um filme com sucesso
    When faco uma requisicao para criar um filme
    Then valido se o filme foi criado

  @editar
  Scenario: Editar um filme com sucesso
    When faco uma requisicao para editar um filme
    Then valido se o filme foi editado