package Tests;

public class C23_AciklamaTestData {

 /*

   Test Datasi Nedir?
   Bir test sirasinda request ile gonderilen (request body) veya test sonucunda donmesi
   beklenen datalari ( expected data ve temel response bilgileri) tamamina test datasi denir.

   Test Data Class Kullanimi

   1) Test datalarimizi tutmak icin Java package altinda bir package olusturalim.
   2) Olusturdugumuz package her endpoint icin bir class olusturup testler icin gerekli olan
      tum test datalarini bu classta olusturalim.
   3) Olusturdugumuz classta temel response bilgileri icin instance variable, request ve response
      body icin metot olusturabiliriz.Ornegin:

      public static int basariliSorguStatusCode = 200;

      public static JSONObject responseBodyOlustur() {

      JSONObject expectedData = new JSONObject();
      expectedData.put("userId", 3);
      expectedData.put("id", 22);
      expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
      expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio
                       \nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

      return expectedData;
  }

      ******Java'da Class Uyelerini Kullanma**********

      1. INHERITANCE (miras)
      Kullandigimiz class'i extends anahtar kelimesi ile istedigimiz classin child'i yapabiliriz.
      Bu durumda object olusturmaya gerek kalmadan parent class'a ulasabililr ve oradaki variable
      ve methodlari kullanabiliriz.(BaseUrl class'lari gibi)
      Inheritance ile variable ve method kullanirken static keyword'e dikkat etmeliyiz. Static olarak
      tanimlanmis bir variable veya method static olmayan method icinden kullanilamaz.

      2. OBJECT OLUSTURARAK
      Bir class'tan obje olusturarak istedigimiz class'a ulasabilir ve o class'taki variable ve metodlari
      oluturdugumuz object araciligi ile kullanabiliriz.

      3. STATIC CLASS UYELERI
      Eger kullanacagimiz variable veya method static ise object olusturmadan dorudan class ismi ile variable
      veya method'a ulasabiliriz.

    Ornegin:

    public class Okul{

       String okulAdi="Yildiz koleji";
       static int ogrenciSayisi=120;

       public void okulMethod(){
          System.out.println("Okulumu seviyorum!");
}
}

 diger class'imiz
    public class Servis{

    Okul okulObj=new.Okul();
    System.out.println(okulObj.okulAdi);
    okulObj.okulMethod();

    System.out.println(Okul.ogrenciSayisi);

}
}

 */


}
