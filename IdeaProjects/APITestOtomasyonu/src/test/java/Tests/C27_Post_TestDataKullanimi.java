package Tests;

import TestDatalari.TestDataHerokuapp;
import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataKullanimi extends BaseUrlHerokuapp {
    /*
  https://restful-booker.herokuapp.com/booking url'ine asagidaki body'e sahip bir POST
  request gonderdigimizde donen response'nin id haric asagidaki gibi oldugunu test edin
  Request Body
  {
  "firstname":"Ahmet"
  "lastname":"Bulut"
  "totalprice":500,
  "depositpaid":false,
  "bookingdates":{
      "checkin":"2023-01-10",
      "checkout":"2023-01-20"
      },
   "additionalneeds":"wi-fi"
   }

   Response Body
   {
   "bookingid":24
   "booking"{
       "firstname":"Ahmet",
       "lastname": "Bulut",
       "totalprice":500,
       "depositpaid":false,
       "bookingdates":{
            "checkin":2021-06-01
            "checkout":2021-06-10
            },
       "additionalneeds'in "wi-fi"
    }
    }
 */
    @Test
    public void test01() {
// 1.endpoint ve request body olustur

        specHerokuapp.pathParam("pp1", "booking");
        JSONObject requestBody = TestDataHerokuapp.jsonRequestBodyOlustur();
        System.out.println(requestBody);

// 2. expected data olustur(soruda varsa)

        JSONObject expectedData = TestDataHerokuapp.jsonResponseBodyOlustur();
        System.out.println(expectedData);

// 3. request gonder ve donen response'yi kaydet

        Response response = given().contentType(ContentType.JSON)
                .spec(specHerokuapp)
                .when().body(requestBody.toString())
                .post("{pp1}");

        response.prettyPrint();
// 4. Assertion
// Expected data: JSONObject
// response: JsonPath

        JsonPath responseJP = response.jsonPath();

        assertEquals(expectedData.getJSONObject("booking").getString("firstname"),
                responseJP.getString("booking.firstname"));

        assertEquals(expectedData.getJSONObject("booking").getString("lastname"),
                responseJP.getString("booking.lastname"));

        assertEquals(expectedData.getJSONObject("booking").getInt("totalprice"),
                responseJP.getInt("booking.totalprice"));

        assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid"),
                responseJP.getBoolean("booking.depositpaid"));

        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds"),
                responseJP.getString("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"),
                responseJP.getString("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"),
                responseJP.getString("booking.bookingdates.checkout"));



    }

    }
