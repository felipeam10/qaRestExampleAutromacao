package support.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

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

    public static void setBody(String contentBody){
        request.body(contentBody);
    }

    public static void getRequest(){
        response = request.get();
    }

    public static void postRequest(){
        response = request.post();
    }

    public static void deleteRequest(){
        response = request.delete();
    }

    public static void putRequest(){
        response = request.put();
    }

    public static void setPathParams(Map<String, String> params){
        request.pathParams(params);
    }

    public static void setQueryParams(Map<String, String> params){
        request.queryParams(params);
    }

    public static void setHeaders(Map<String, String> params){
        request.headers(params);
    }

    public static Response getResponse(){
        return response;
    }
}
