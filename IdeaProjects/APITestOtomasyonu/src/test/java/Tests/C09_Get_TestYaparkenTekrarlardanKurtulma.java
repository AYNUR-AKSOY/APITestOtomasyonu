package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_TestYaparkenTekrarlardanKurtulma {

 /*

     https://restful-booker.herokuapp.com/booking/10 url'ine
     bir GET request gonderdigimizde donen response'un,

        status code'unu 200'
        ve content type'inin Application-JSON
        ve response body'sindeki
         "firstname" in "Susan"
         "lastname" in "Jackson"
         "totalprice" in 1000'den kucuk oldugunu
         "depositpaid" in false
         "additionalneeds" in bos birakilmadigini
         oldugunu test edin

     */

    @Test
    public void test01(){

// 1. end-point ve request body hazirla
        String url="https://restful-booker.herokuapp.com/booking/10";

// 2. expected body olustur

// 3. request gonder ve donen response'yi kaydet

        Response response = given()
                .when()
                .get(url);
        response.prettyPrint();

// 4. Assertion
/*
ikinci yontem ile yaptigimizda bu testte yazilanlar degismesin diye yoruma alindi

response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Sally"))
                .body("lastname", Matchers.equalTo("Brown"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid", Matchers.equalTo(false))
                .body("additionalneeds", Matchers.nullValue());
*/
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Sally"),
                        "lastname", equalTo("Brown"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds",nullValue());


    }
}


