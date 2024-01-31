package Tests;

import Pojos.PojosHavaDurumu.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C34_Post_Pojo {

    // "https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2fO"
//url'ine bir post request gonderdigimizde donen response'un asagidaki body'e sahip oldugunu
// test edin
    /*
{
    "coord": {
          "lon": 10.99,
          "lat": 44.34
},
    "weather": [
    {
        "id": 501,
        "main": "Rain",
        "description": "moderate rain",
        "icon": "10d"
    }
  ],
    "base": "stations",
    "main": {
            "temp": 298.48,
            "feels_like": 298.74,
            "temp_min": 297.56,
            "temp_max": 300.05,
            "pressure": 1015,
            "humidity": 64,

},
    "visibility": 10000,
    "wind": {
            "speed": 0.62,
            "deg": 349,
},

    "clouds": {
        "all": 100
},
    "dt": 1661870592,
    "sys": {
            "type": 2,
            "id": 2075663,
            "country": "IT",
            "sunrise": 1661834187,
            "sunset": 1661882248
},
    "timezone": 7200,
    "id": 3163858,
    "name": "Zocca",
    "cod": 200
}
*/
    @Test
    public void test01() {

        // 1. Request url ve body gonder
        String url = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2fO";

        // 2. Soruda varsa expected data olustur
        Coord coordPojo = new Coord(10.99f, 44.34f);
        List<Weather> weatherList = new ArrayList<Weather>();
        Weather weatherPojo = new Weather(501, "Rain", "moderate rain", "10d");
        weatherList.add(weatherPojo);
        Main mainPojo = new Main(298.48f, 298.74f, 297.56f, 300.05f, 1015, 65);
        Wind windPojo = new Wind(0.62f, 349);
        Clouds cloudsPojo = new Clouds(100);
        Sys sysPojo = new Sys(2, 2075663, "IT", 1661834187, 1661882248);
        PojoHavaDurumu expectedResponseBody = new PojoHavaDurumu(coordPojo, weatherList,
                "stations", mainPojo, 10000, windPojo, cloudsPojo, 1661870592, sysPojo,
                7200, 3163858, "Zocca", 200);

        // 3.Request gonder donen response'yi kaydet
        Response response = given()
                .when()
                .post(url);

        response.prettyPrint();

        // 4.Assertion

// ecpectedResponseBody Pojo<---->response/responseJP
PojoHavaDurumu responsePojo = response.as(PojoHavaDurumu.class);

// response'yi Pojo'ya cevirdigimizde tum bilgileri getirirse responsePojo'yu
// assertion'da kullanabiliriz.Eger null deger donerse, response'yi JsonPath yapip
// assertion'da kullanabiliriz.(burada null gelenler oldu, bu nedenle JsopnPath
// olusturuldu ve degismeyen degerlerden birkaci asert edildi.)
        System.out.println(responsePojo);//bu ciktida null degerler oldugu goruluyor,
        // bu nedenle JsonPath kullanildi

        JsonPath responseJP = response.jsonPath();
        assertEquals(expectedResponseBody.getCoord().getLon(),
                responseJP.get("coord.lon"));

       assertEquals(expectedResponseBody.getCoord().getLat(),
                responseJP.get("coord.lat"));

        assertEquals(expectedResponseBody.getSys().getCountry(),
                responseJP.get("sys.country"));

        assertEquals(expectedResponseBody.getName(),
                responseJP.get("name"));

    }
    }
