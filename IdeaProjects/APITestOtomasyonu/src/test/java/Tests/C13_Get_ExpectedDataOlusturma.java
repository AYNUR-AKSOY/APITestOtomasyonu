package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C13_Get_ExpectedDataOlusturma {

 /*
 https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
  donen response body'sinin asagida verilen ile ayni oldugunu test ediniz.
  {
  "userId":3'
  "id";22,
  "title":"dolor sint quo a velit explicabo quia nam",
  body":"eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
  um mollitia molestiae aut atque rem suscipitnam impedit esse"
  }
  */

    @Test
    public void method01(){

// 1. end-point ve request body hazirla
        String url="https://jsonplaceholder.typicode.com/posts/22";
// 2. expected data olustur

    JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear\n" +
                "  um mollitia molestiae aut atque rem suscipitnam impedit esse");
//System.out.println(expectedData.toString());

// 3. request gonder ve donen response'yi kaydet

        Response response = given()
                .when()
                .get(url);
        response.prettyPrint();

        // 4. Assertion
/*

 Bugune kadar yaptigimiz yontemle de testimizi yapabiliriz.
 Ancak frameworkumuzu gelistirmeye devam etmeliyiz.

        response
                .then()
                .assertThat()
                .statusCode(200)

                .body("userId",equalTo(3),
                        "id",equalTo(22),
                        "title",equalTo("dolor sint quo a velit explicabo quia nam"));
*/

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));
        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));


    }

}
