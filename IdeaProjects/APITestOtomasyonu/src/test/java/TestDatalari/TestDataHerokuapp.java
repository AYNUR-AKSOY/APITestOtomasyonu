package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {


    public static JSONObject jsonRequestBodyOlustur() {

        JSONObject requestBody = new JSONObject();

        JSONObject bookingdatesBody = new JSONObject();
        bookingdatesBody.put("checkin", "2021-06-01");
        bookingdatesBody.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", bookingdatesBody);
        requestBody.put("additionalneeds", "wi-fi");

        return requestBody;
    }

    public static JSONObject jsonResponseBodyOlustur() {
        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody = jsonRequestBodyOlustur();
        responseBody.put("bookingid", 24);
        responseBody.put("booking", bookingBody);

        return responseBody;

    }


    public static Map<String, Object> RequestBodyMapOlustur() {

        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname", "Ahmet");
        requestBodyMap.put("lastname", "Bulut");
        requestBodyMap.put("totalprice", 500);
        requestBodyMap.put("depositpaid", false);
        requestBodyMap.put("bookingdates", BookingDatesMapOlustur());
        requestBodyMap.put("additionalneeds", "wi-fi");

        return requestBodyMap;

    }

    public static Map<String,String> BookingDatesMapOlustur() {

        Map<String, String> bookingDatesMAp = new HashMap<>();
        bookingDatesMAp.put("checkin", "2021-06-01");
        bookingDatesMAp.put("checkout", "2021-06-10");

        return bookingDatesMAp;
    }

    public static Map<String, Object> responseBodyMapOlustur(){

        Map<String, Object> responseBodyMap= new HashMap<>();
        responseBodyMap.put("bookingid", 24);
        responseBodyMap.put("booking",RequestBodyMapOlustur());

        return responseBodyMap;

    }

}
