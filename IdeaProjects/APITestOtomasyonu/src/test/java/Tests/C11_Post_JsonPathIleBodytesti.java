package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_Post_JsonPathIleBodytesti {

/*
  https://restful-booker.herokuapp.com/booking url'ine asagidaki body'e sahip
   bir POST request gonderdigimizde
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

   donen response'un:
   status code'unun200'
   content type'inin application-json,
   "firstname"nin "Ahmet",
   "lastname"in "Bulut",
   "totalprice"nin 500,
   "depositpaid"in false,
   "checkin" tarihinin 2023-01-10
   "checkout" tarihinin 2023-01-20
   "additionalneeds'in "wi-fi" oldugunu test edin
 */

   @Test
   public void method01(){
       // 1. end-point ve request body hazirla
       String url="https://restful-booker.herokuapp.com/booking";

       JSONObject requestBody = new JSONObject();
       JSONObject rezervasyonTarihleriJson = new JSONObject();

       rezervasyonTarihleriJson.put("checkin","2023-01-10");
       rezervasyonTarihleriJson.put("checkout","2023-01-20");

       requestBody.put("firstname","Ahmet");
       requestBody.put("lastname","Bulut");
       requestBody.put("totalprice",500);
       requestBody.put("depositpaid",false);
       requestBody.put("bookingdates",rezervasyonTarihleriJson);
       requestBody.put("additionalneeds","wi-fi");
       System.out.println("requestBody");

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
               .statusCode(200)
               .contentType(ContentType.JSON)
               .body("booking.firstname",equalTo("Ahmet"),
                       "booking.lastname", equalTo("Bulut"),
                       "booking.totalprice", equalTo(500),
                       "booking.depositpaid", equalTo(false),
                       "booking.additionalneeds",equalTo("wi-fi"),
                       "booking.bookingdates.checkin",equalTo("2023-01-10"),
                       "booking.bookingdates.checkout",equalTo("2023-01-20"));

   }

}
