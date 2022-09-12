package support.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestContext {

    private static RequestSpecification request;
    private static Response response;

    public static void initRequest(){
        RestAssured.useRelaxedHTTPSValidation();
        request = RestAssured.given();
    }

    public static void setPath(String BaseUri, String path){
        if(request == null){
            initRequest();
        } else {
            request.baseUri(BaseUri);
            request.basePath(path);
        }
    }

    public static void getRequest(){
        response = request.get();
    }

    public static Response getResponse(){
        return response;
    }
}
