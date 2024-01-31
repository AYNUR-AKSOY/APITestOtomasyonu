package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class C28_Put_Deserialization extends BaseUrlJsonPlaceholder {
 /*
 https://jsonplaceholder.typicode.com/posts/70 url/sine asagidaki body'e sahip bir PUT
 request yolladigimizda donen response'in response body'sinin asagida verilen ile ayni
 oldugunu test ediniz

 Request Body
 {
 "title":"Ahmet",
 "body":"Merhaba",
 "userId":10,
 "id":70
 {

 Expected Data (Response body)
 {
 "title":"Ahmet",
 "body":"Merhaba",
 "userId":10,
 "id":70
 {

  */

    @Test
    public void test01(){


// 1.endpoint ve request body olustur
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 70);
// body'i map kullanarak olusturacagiz

        Map<String, Object> requestBodyMap = TestDataJsonPlaceholder.bodyOlusturMap();
        System.out.println("request body: "+ requestBodyMap);


// 2. expected data olustur(soruda varsa)

        Map<String, Object> expectedData = TestDataJsonPlaceholder.bodyOlusturMap();


// 3. request gonder ve donen response'yi kaydet

        Response response = given().contentType(ContentType.JSON)
                .spec(specJsonPlaceholder)
                .when().body(requestBodyMap)
                .put("{pp1}/{pp2}");

        response.prettyPrint();

// 4. Assertion
// Assertion yapabilmemiz icin response'yi Map'e cevirmemiz gerekir(De-serialization)

        Map<String, Object> responseMap = response.as(HashMap.class);
        System.out.println("response map:"+ responseMap);

    Assert.assertEquals(expectedData.get("title"),responseMap.get("title"));
    Assert.assertEquals(expectedData.get("body"),responseMap.get("body"));
    Assert.assertEquals(expectedData.get("userId"),responseMap.get("userId"));
    Assert.assertEquals(expectedData.get("id"),responseMap.get("id"));


    }
}