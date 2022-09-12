package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import support.enums.ApiPath;
import support.enums.BaseUri;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static support.utils.RestContext.*;

public class FilmeStepDefinition {

    ValidatableResponse response;

    @When("faco uma requisicao para a url de filme")
    public void faco_uma_requisicao_para_a_url_de_filme() {
        initRequest();
        setPath(BaseUri.BASE_URI.getUri(), ApiPath.GET_FILMES.getPath());
        getRequest();
        response = getResponse().then().log().all();
    }
    @Then("valido se a resposta")
    public void valido_se_a_resposta() throws IOException, JSONException {
//        assertEquals(Integer.valueOf(1), response.extract().path("[0].codigo"));
//        assertEquals("matrix", response.extract().path("[0].nome"));
//        assertEquals("sinopse1", response.extract().path("[0].sinopse"));
//        assertEquals("14", response.extract().path("[0].faixaEtaria"));
//        assertEquals("acao", response.extract().path("[0].genero"));
//
//        assertEquals(Integer.valueOf(4), response.extract().path("[3].codigo"));
//        assertEquals("osTrapalhoes", response.extract().path("[3].nome"));
//        assertEquals("sinopse4", response.extract().path("[3].sinopse"));
//        assertEquals("05", response.extract().path("[3].faixaEtaria"));
//        assertEquals("comedia", response.extract().path("[3].genero"));

        String jsonASerValidado = new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/respostaFilmes.json")));

        JSONAssert.assertEquals(jsonASerValidado, response.extract().asString(), true);
    }
}
