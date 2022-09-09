package step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static org.junit.Assert.assertEquals;
import static support.utils.GetProperties.getProp;

public class StatusStepDefinitions {

    ValidatableResponse response;

    @When("faco uma requisicao para a url de status")
    public void faco_uma_requisicao_para_a_url_de_status() {
        response = RestAssured
                .given()
                    .log().all()
                .when()
                    .get(getProp("urlBase") + "/status")
                .then()
                    .log().all()
        ;

    }
    @Then("valido se a resposta foi com status {string}")
    public void valido_se_a_resposta_foi_com_status(String string) {
        assertEquals(200, response.extract().statusCode());
        assertEquals("A aplicação está de pernas para o ar", response.extract().body().asPrettyString());
    }
}
