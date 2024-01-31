package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_GET_ResponseDegerleriniOtomasyonIleTestEtme {

    @Test
    public void test01() {
// https://restful-booker.herokuapp.com/booking/10 url'ine gidin
        // GET request gonderdigimizde donen Response'nin, status code'nun 200,
        // content type'inin 'application/json; charset=utf-8,
        // server isimli Header'in degerinin Cowboy,
        // status line'in HTTP/1.1 200 OK
        // oldugunu test ediniz

        //1. gerekli body ve end-pointi hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2.expected body olustur
        //3. request gonder ve donen response'i kaydet
        Response response = given().when().get(url);

        //4. assertion


        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Cowboy")
                .statusLine("HTTP/1.1 200 OK");


    }
}