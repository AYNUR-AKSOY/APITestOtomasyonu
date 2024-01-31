package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
    /*
       https://restful-booker.herokuapp.com/booking endpointine
   gerekli query parametrelerini yazarak "firstname" degeri
   "Susan" ve "lastname" degeri "Jones" olan rezervasyon oldugunu test edecek bir GET request
   gonderdigimizde donen response'nin status code'nun 200 oldugunu
   ve "Susan Jones" ismine sahip  en az bir booking oldugunu test edin
   */
    @Test
    public void test01(){

// 1.endpoint ve request body olustur
        specHerokuapp.pathParams("pp1","booking").queryParams("firstname","Susan","lastname","Jones");


// 2. expected data olustur

// 3. request gonder ve donen response'yi kaydet

        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        response.prettyPrint();

// 4. Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(2));
    }

}
