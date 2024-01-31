package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    /*https://jsonplaceholder.typicode.com/posts/70 url'ine bir PUT request
    gonderdigimizde donen response'un, status code'unun 200,
    content type'inin "Application/json; charset=utf-8
    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }

    Response Body(expected data)
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }

 */
    @Test
    public void test01() {
// 1.endpoint ve request body olustur
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "70");

        JSONObject requestBody = TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");
    //    System.out.println(requestBody);

// 2. expected data olustur

JSONObject expectedData=TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");
        System.out.println(expectedData);

// 3. request gonder ve donen response'yi kaydet
        Response response = given().contentType(ContentType.JSON)
                .when().spec(specJsonPlaceholder).body(requestBody.toString())
                .put("/{pp1}/{pp2}");

        response.prettyPrint();


// 4. Assertion
        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());

        assertEquals(expectedData.getInt("userId"),responseJsonpath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonpath.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonpath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonpath.getString("body"));

    }
}




