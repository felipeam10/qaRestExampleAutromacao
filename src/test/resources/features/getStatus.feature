Feature: Pegar Status do servidor

  Scenario: Validar status do servidor
    When faco uma requisicao para a url de status
    Then valido se a resposta foi com status "200"