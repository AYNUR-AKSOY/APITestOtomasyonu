package Tests;

import TestDatalari.TestDataDummyExample;
import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_Deserialization extends BaseUrlDummyExample {
/*
http:dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request
gonderdigimizde donen response'un status code'unun 200,content type'inin
 application/json ve body'sinin asagidaki gibi oldugunu test edin.
Response Body
{
"status":"success",
"data":{
      "id":3,
      "employee_name":"Ashton Cox",
      "employee_salary":86000,
      "employee_age":66,
      "profile_image":"",
      },
"message":"Successfully! Record has been fetched."
}
 */

    @Test
    public void test01() {
// 1.endpoint ve request body olustur
        specDummyExample.pathParams("pp1", "employee", "pp2", "3");

// 2. soruda varsa expected data olustur
        Map<String, Object> expectedData = TestDataDummyExample.mapBodyOlustur();
        System.out.println("expectedData: "+ expectedData);

// 3. request gonder ve donen response'yi kaydet
        Response response = given().spec(specDummyExample)
                .when()
                .get("/{pp1}/{pp2}");

        response.prettyPrint();

// 4. Assertion
        Map<String, Object> responseMap = response.as(HashMap.class);
        System.out.println("response map:"+ responseMap);


        assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataDummyExample.contentType,response.contentType());

        assertEquals(expectedData.get("message"),responseMap.get("message"));
        assertEquals(expectedData.get("status"),responseMap.get("status"));

        assertEquals(((Map)expectedData.get("data")).get("profile_image"),
                ((Map)responseMap.get("data")).get("profile_image"));

        assertEquals(((Map)expectedData.get("data")).get("employee_name"),
                ((Map)responseMap.get("data")).get("employee_name"));

        assertEquals(((Map)expectedData.get("data")).get("employee_salary"),
                ((Map)responseMap.get("data")).get("employee_salary"));

       assertEquals(((Map)expectedData.get("data")).get("id"),
                ((Map)responseMap.get("data")).get("id"));

        assertEquals(((Map)expectedData.get("data")).get("employee_age"),

                ((Map)responseMap.get("data")).get("employee_age"));



    }
}