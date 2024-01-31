package Tests;

import TestDatalari.TestDataDummyExample;
import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class C26_Get_TestDatakullanimi extends BaseUrlDummyExample {
/*
http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request
gonderdigimizde donen response'un status code'unun 200,content type'inin
 application/json ve body'sinin asagidaki gibi oldugunu test edin.

Expected Response Body
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

// 2. expected data olustur

        JSONObject expectedData = TestDataDummyExample.jsonResponseBodyOlustur(3,
                "Ashton Cox",
                86000,
                66,
                "");

        System.out.println(expectedData);

// 3. request gonder ve donen response'yi kaydet
        Response response = given().spec(specDummyExample)
                .when()
                .get("/{pp1}/{pp2}");


        response.prettyPrint();


// 4. Assertion
// Expected data: JSONObject
// response: JsonPath

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataDummyExample.basariliSorguStatusCode, response.statusCode());
        assertEquals(TestDataDummyExample.contentType, response.contentType());


// data alanındaki değerleri kontrol et

        assertEquals(expectedData.getJSONObject("data").getInt("id"),
                responseJsonpath.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),
                responseJsonpath.getString("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"),
                responseJsonpath.getInt("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"),
                responseJsonpath.getInt("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),
                responseJsonpath.getString("data.profile_image"));

// message değerini kontrol et
        assertEquals(expectedData.getString("message"), responseJsonpath.getString("message"));

// status değerini kontrol et
        assertEquals(expectedData.getString("status"), responseJsonpath.getString("status"));

    }
}