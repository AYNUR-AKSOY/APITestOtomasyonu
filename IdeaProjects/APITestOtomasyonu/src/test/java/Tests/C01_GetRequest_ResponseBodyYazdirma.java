package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdirma {


    @Test
    public void test01(){

        // https://restful-booker.herokuapp.com/booking/10 url'ine gidin
        // bir GET reguest gonderdigimizde donen responsu yazdirin
        //1. request body ve end-point hazirlama

        String url="https://restful-booker.herokuapp.com/booking/10";

        //2. Expected data hazirlama

        //3. request gonderip, donen response'i kaydetme

        Response response = given().when().get(url);
        response.prettyPrint();

        //4. assertion islemleri

    }

}


