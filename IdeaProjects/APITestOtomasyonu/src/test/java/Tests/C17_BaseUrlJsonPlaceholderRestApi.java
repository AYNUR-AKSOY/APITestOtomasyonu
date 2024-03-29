package Tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlJsonPlaceholderRestApi extends BaseUrlJsonPlaceholder {

// class icinde 3 tane test metodu olusturun ve asagidaki testleri yapin


 @Test
 public void test01(){

 // 1. https://jsonplaceholder.typicode.com/posts endpointine bir GET reguest
 // gonderdigimizde donen response'in status code'unun 200 oldugunu ve response'de
 // 100 kayit oldugunu test edin

 // 1.endpoint ve request body olustur

     specJsonPlaceholder.pathParam("pp1","posts");//pp1:path parama verdigimiz isim

 // 2. expected data olustur

 // 3. request gonder ve donen response'yi kaydet

     Response response = given()
             .when().spec(specJsonPlaceholder)
             .get("/{pp1}");

     response.prettyPrint();
 //4. Assertion
    response
            .then()
            .assertThat()
            .statusCode(200)
            .body("title", Matchers.hasSize(100));
 }
@Test
    public void test02(){

// 2. https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
// request gonderdigimizde donen response'nin status code'nun 200 oldugunu
// ve "title" degerinin "optio dolor molestias sit" oldugunu test edin

// 1.endpoint ve request body olustur
    specJsonPlaceholder.pathParams("pp1","posts","pp2",44);
// 2. expected data olustur

// 3. request gonder ve donen response'yi kaydet

    Response response = given()
            .when().spec(specJsonPlaceholder)
            .get("/{pp1}/{pp2}");

    response.prettyPrint();
// 4. Assertion
    response
            .then()
            .assertThat()
            .statusCode(200)
            .body("title", Matchers.equalTo("optio dolor molestias sit"));
}


@Test
    public void test03(){

// 3. https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
// request gonderdigimizde donen response;nin status code'nun 200 oldugunu
// ve response body'sinin null oldugunu test edin

// 1.endpoint ve request body olustur
    specJsonPlaceholder.pathParams("pp1","posts","pp2",50);
// 2. expected data olustur

// 3. request gonder ve donen response'yi kaydet

    Response response = given()
            .when().spec(specJsonPlaceholder)
            .delete("/{pp1}/{pp2}");

    response.prettyPrint();

// 4. Assertion
    response
            .then()
            .assertThat()
            .statusCode(200)
            .body("title", Matchers.nullValue());
}


}





