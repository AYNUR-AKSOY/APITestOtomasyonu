package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp1 extends BaseUrlHerokuapp {
@Test
        public void test01(){
// https://restful-booker.herokuapp.com/booking endpointine bir GET
// request gonderdigimizde donen response'nin status code'nun 200 oldugunu
// ve response'da 12 booking oldugunu test edin

// 1.endpoint ve request body olustur
    specHerokuapp.pathParams("pp1","booking");
// 2. expected data olustur

// 3. request gonder ve donen response'yi kaydet

    Response response = given()
            .when().spec(specHerokuapp)
            .get("/{pp1}");

    //response.prettyPrint();

// 4. Assertion

    JsonPath responseJsonpath = response.jsonPath();
    System.out.println(responseJsonpath.getList("bookingid").size());
    // 32 ve 33 satirda jsonpath'den yararlanarak bookingid'nin kac tane oldugunu buluyoruz,
    // cunku sayisi surekli eklemeler oldugu icin degisiyor. Sonra da bu sayiyi assert ediyoruz.

    response
            .then()
            .assertThat()
            .statusCode(200)
            .body("bookingid",Matchers.hasSize(2500));
            //.body("bookingid",Matchers.hasSize(responseJsonpath.getList("bookingid").size()));// sayi surekli degistigi icin test
    // failed oluyor
}

}
