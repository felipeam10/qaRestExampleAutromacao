package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import model.FilmeModel;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import support.enums.ApiPath;
import support.enums.BaseUri;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

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

    @When("faco uma requisicao para a url de filme passando o código")
    public void faco_uma_requisicao_para_a_url_de_filme_passando_o_código() {
        initRequest();
        //http://localhost:8080/filme/{codigo}
        setPath(BaseUri.BASE_URI.getUri(), ApiPath.GET_FILME.getPath());
        Map<String, String> params = new HashMap<String, String>();
        params.put("codigo", "1");
        setPathParams(params);

        getRequest();
        response = getResponse().then().log().all();
    }

    @Then("valido a resposta de um filme")
    public void valido_a_resposta_de_um_filme() {
        assertEquals(Integer.valueOf(1), response.extract().path("codigo"));
        assertEquals("matrix", response.extract().path("nome"));
        assertEquals("sinopse1", response.extract().path("sinopse"));
        assertEquals("14", response.extract().path("faixaEtaria"));
        assertEquals("acao", response.extract().path("genero"));
        response = getResponse().then().log().all();
    }

    @When("faco uma requisicao para deletar um filme")
    public void faco_uma_requisicao_para_deletar_um_filme() {
        initRequest();
        setPath(BaseUri.BASE_URI.getUri(), ApiPath.DELETE_FILME.getPath());
        Map<String, String> params = new HashMap<String, String>();
        params.put("codigo", "5");
        setPathParams(params);

        deleteRequest();
        response = getResponse().then().log().all();
    }

    @Then("valido se o filme foi deletado")
    public void valido_se_o_filme_foi_deletado() {
        response.statusCode(404);
    }

    @When("faco uma requisicao para criar um filme")
    public void faco_uma_requisicao_para_criar_um_filme() {
        initRequest();
        setPath(BaseUri.BASE_URI.getUri(), ApiPath.POST_CRIAR_FILME.getPath());
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        setHeaders(headers);

        //Coloquei para gerar apenas o código do filme aleatório
        Faker teste = new Faker();
        Integer randonNumber = teste.number().numberBetween(6,99);

        FilmeModel bodyObjeto = new FilmeModel(randonNumber, "topGun", "sinopse6", "16","acao");
        System.out.println(bodyObjeto.toString());
        setBody(bodyObjeto.toString());
        postRequest();
        response = getResponse().then().log().all();
    }

    @Then("valido se o filme foi criado")
    public void valido_se_o_filme_foi_criado() {

    }

}
