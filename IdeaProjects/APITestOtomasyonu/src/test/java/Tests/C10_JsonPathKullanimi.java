package Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    /*
   {
   "firstName" : "John",
   "lastName" : "doe",
   "age" : 26,
   "address" : {
         "streetAddress" : "naist street",
         "city" : "Nara",
         "postalCode" : "630-0192"
         },
    "phoneNumbers" : [
         {
             "type" : "iPhone",
             "number" : "0123-4567-8888"
         },
         {
             "type" : "home",
             "number" : "0123-4567-8910"
          }
       ]
    }

   JSONPath kullanimi

   JSONPath, JSON verilerini okuma ve update etme firsati verir.
   Bir JSON objesinin icinde birden fazla data turunde primitive data veya obje bulunabilir.
   Ornegin yukaridaki JSON objesi incelenirse
   firstName----> String
   lastName----> String
   age---->int
   address----> Json objesi
   phoneNumbers ise icinde iki Json objesi olan bir array'dir.

     */

  @Test
  public void method01(){

      JSONObject kisiBilgileriJsonObject = new JSONObject();

      JSONObject adresJsonObj=new JSONObject();

      JSONArray telefonBilgileriArr=new JSONArray();
      JSONObject cepTelJsonObject=new JSONObject();
      JSONObject evTelJsonObject=new JSONObject();

      adresJsonObj.put("streetAddress","naist street");
      adresJsonObj.put("city","nara");
      adresJsonObj.put("postalCode","639-0192");

      cepTelJsonObject.put("type","iPhone");
      cepTelJsonObject.put("number","0123-4567-8888");
      evTelJsonObject.put("type","home");
      evTelJsonObject.put("number","0123-4567-8910");
      telefonBilgileriArr.put(cepTelJsonObject);
      telefonBilgileriArr.put(evTelJsonObject);


      kisiBilgileriJsonObject.put("firstName","John");
      kisiBilgileriJsonObject.put("lastName","doe");
      kisiBilgileriJsonObject.put("age",26);
      kisiBilgileriJsonObject.put("address",adresJsonObj);
      kisiBilgileriJsonObject.put("phoneNumbers",telefonBilgileriArr);

      System.out.println(kisiBilgileriJsonObject);

      System.out.println("firstName: "+ kisiBilgileriJsonObject.get("firstName"));
      System.out.println("lastName: "+ kisiBilgileriJsonObject.get("lastName"));
      System.out.println("cadde: "+kisiBilgileriJsonObject.getJSONObject("address").get("streetAddress"));
      System.out.println("city: "+kisiBilgileriJsonObject.getJSONObject("address").get("city"));
      System.out.println("cep tel no: "+kisiBilgileriJsonObject.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));

  }

}
