package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_ResponseBodyTesti {
    /*

     https://jsonplaceholder.typicode.com/posts/44 url'ine
     bir GET request gonderdigimizde donen response'un,
        status code'unu 200'
        ve content type'inin Application.JSON
        ve response body'sinde bulunan userId'nin 5,
        ve response body'sinde bulunan title'in 'optio dolor molestias sit'
        oldugunu test edin

     */
//*** response body'sindeki degerleri test etmek icin Matchers class'indan yardim aliriz.

    @Test
    public void test01(){
// 1. end-point ve request body hazirla
        String url="https://jsonplaceholder.typicode.com/posts/44 ";


// 2. expected body olustur

// 3. request gonder ve donen response'yi kaydet

        Response response = given()
                .when()
                .get(url);
        response.prettyPrint();

// 4. Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))
                .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }
}
