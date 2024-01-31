package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTesti {
  /*

     https://jsonplaceholder.typicode.com/posts url'ine

     asagidaki body ile bir POST request gonderdigimizde
     {
     "title":"API",
     "body":"API ogrenmek ne guzel!",
     "userId";10
     }
     donen response'un,
        status code'unu 201'
        ve content type'inin Application.JSON
        ve response body'sinde bulunan
        "title" nin "API" oldugunu,
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini test edin

     */
@Test
public void test01(){

    // 1. end-point ve request body hazirla
    String url="https://jsonplaceholder.typicode.com/posts";

    JSONObject requestBody = new JSONObject();
    requestBody.put("title","API");
    requestBody.put("Body","API ogrenmek ne guzel!");
    requestBody.put("userId",10);
    // 2. expected body olustur

    // 3. request gonder ve donen response'yi kaydet

    Response response = given().contentType(ContentType.JSON)
            .when().body(requestBody.toString())
            .post(url);
    response.prettyPrint();


    // 4. Assertion
    response
            .then()
            .assertThat()
            .statusCode(201)
            .contentType(ContentType.JSON)
            .body("title", Matchers.equalTo("API"))
            .body("userId",Matchers.lessThan(100))
            .body("Body", Matchers.containsString("API"));
}
}



