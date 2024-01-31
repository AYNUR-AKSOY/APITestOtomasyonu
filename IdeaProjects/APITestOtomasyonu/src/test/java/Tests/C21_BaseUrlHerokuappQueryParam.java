package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
 /*
    https://restful-booker.herokuapp.com/booking endpointine
gerekli query parametrelerini yazarak "firstname" degeri
"Susan" olan rezervasyon oldugunu test edecek bir GET request
gonderdigimizde donen response'nin status code'nun 200 oldugunu
ve "Susan" ismine sahip (4) booking oldugunu test edin
*/
@Test
public void test01(){

    // 1.endpoint ve request body olustur
    specHerokuapp.pathParams("pp1","booking").queryParam("firstname","Susan");


// 2. expected data olustur

// 3. request gonder ve donen response'yi kaydet

    Response response = given()
            .when().spec(specHerokuapp)
            .get("/{pp1}");

    response.prettyPrint();// Susan isminde 4 kisi cikiyor, bu degisiyor surekli

// 4. Assertion

    response
            .then()
            .assertThat()
            .statusCode(200)
            .body("bookingid",Matchers.hasSize(4));
}

}
