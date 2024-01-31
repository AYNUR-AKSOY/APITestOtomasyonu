package Tests;

import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class C02_GetRequest_ResponseBilgilerininTestEdilmesi {

  @Test
  public void test01(){

     // https://restful-booker.herokuapp.com/booking/10 url'ine gidin
     // GET request gonderdigimizde donen Response'nin, status code'nun 200,
     // content type'inin 'application/json; charset=utf-8,
     // server isimli Header'in degerinin Cowboy,
     // status line'in HTTP/1.1 200 OK,
     // response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.

     //1. gerekli body ve end-pointi hazirlama
     String url="https://restful-booker.herokuapp.com/booking/10";

     //2.expected body olustur
     //3. request gonder ve donen response'i kaydet
      Response response = given().when().get(url);
      //System.out.println(response.getBody().toString());bu bize bir referans degeri verir,
      //bu nedenle body() metodu olsa bile yazdiramiyoruz, prettyPrint() kullaniriz.
      response.prettyPrint();

      System.out.println("status code: " +response.getStatusCode()+
                          "\n Content type: "+ response.getContentType()+
                          "\n Server Header degeri: "+ response.getHeader("server")+
                          "\n Status line: "+ response.getStatusLine()+
                          "\n Response suresi: "+ response.getTime()+"ms");

  }

}
