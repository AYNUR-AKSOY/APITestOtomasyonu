package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_PUT_ResponseBilgileriAssertion {

    @Test
    public void test01(){
/*

// https://jsonplaceholder.typicode.com/posts/70 url'ine
// asagidaki json formatindaki body ile bir PUT request gonderdigimizde
   {
    "title":"Ahmet",
    "body":"Merhaba!",
    "userId":10,
    "id":70
    }
// donen response'un,
// status code'unu 200'
// ve content type'inin application/json; charset=utf-8,
// ve Server isimli header'in degerinin cloudflare,
// ve status line'in HTTP/1.1 200 OK

 */

// 1. end-point ve request body hazirla
String url="https://jsonplaceholder.typicode.com/posts/70 ";
JSONObject requestBody = new JSONObject();

      requestBody.put("title","Ahmet");
      requestBody.put("body","Merhaba!");
      requestBody.put("userId",10);
      requestBody.put("id",70);

// 2. expected body olustur
// 3. request gonder ve donen response'yi kaydet

Response response = given().contentType(ContentType.JSON)
        .when().body(requestBody.toString())
        .put(url);
response.prettyPrint();

// 4. Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }
}
