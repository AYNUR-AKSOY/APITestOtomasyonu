package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    /*

       https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
       gonderdigimizde donen response'un, status code'unun 200 ve response body'sinin
       asagida verilen ile ayni oldugunu test ediniz.
       Response body:
       { "userId": 3,
         "id": 22,
         "title": "dolor sint quo a velit explicabo quia nam",
         "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
         um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
       */
    @Test
    public void test01() {
// 1. endpoint ve request body olustur
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "22");//pp1:path parama verdigimiz isim


// 2. expected data olustur
//      expected data'yi TestDataJsonPlaceholder'a aldik

//        JSONObject expectedData = new JSONObject();
//        expectedData.put("UserId", 3);
//        expectedData.put("id", 22);
//        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
//        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut sed omnis non odio " +
//                "expedita ear um mollitia molestiae aut atque rem suscipitnam impedit esse");

JSONObject expectedData = TestDataJsonPlaceholder.responseBodyOlustur22();
        System.out.println(expectedData);

// 3. request gonder ve donen response'yi kaydet
        Response response = given()
                .when().spec(specJsonPlaceholder)
                .get("/{pp1}/{pp2}");

        response.prettyPrint();


// 4. Assertion
        JsonPath responseJsonpath = response.jsonPath();

        Assert.assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonpath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonpath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonpath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonpath.getString("body"));
    }
}
