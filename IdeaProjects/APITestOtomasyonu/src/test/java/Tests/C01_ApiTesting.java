package Tests;

public class C01_ApiTesting {


    /*

    Her Api sorgusu client ile server arasinda bir iletisim demektir. HTTP protokolu
    bu iletisimin kurallarini belirler. Hangi islem icin ne tur bir Request gondermemiz
    gerektigi ve protokole uygun olarak gonderdigimiz Request karsiliginda Server'in ne
    tur bir cevap donecegi net olarak bellidir.
    API'nin saglikli olarak calisip calismadigini test etmek icin asagida belirlenen
    yontemle API testleri yapilir.

    1. Onceden belirlenmis senaryoya uygun bir request, Server'e gonderilir.
    2. Gonderdigimiz Request'in karsiliginda Server'in donmesi gereken Response belirlenir
    (Expected Data)
    3. Request gonderilip, request karsiliginda Server'in dondurdugu response kaydedilir.
    (Actual Data)
    4. Expected Data ile Actual Data karsilastirilir (Assertion) fark varsa rapor edilir.

    IntelliJ'de API sorgulari yapmak icin io.restAssured kutuphanesi kullanilir ve Response
    class'indan bir obje olusturmamiz gerekir.
             Response response = given().when().get(url);
    Response olustururken kullandigimiz
    given: Testimize baslarken bize verilen baslangic degerlerini ifade eder.
    when: Testimizde gerceklestirdigimiz islemleri ifade eder.
    then: Response degerlerini degerlendirmek icin yapilan islemleri ifade eder.
    and: Birbirine bagli islemleri ifade eder.

    PUT, POST ve PATCH request'leri yapilirken server'e olusturulmasi/ degistirilmesi istedigimiz
    yeni bilgileri gondermek zorundayiz. Bunun icin farkli data tipleri ile body olusturulabilir.
    Olusturulma kolayligi ve data tiplerini kabul esnekligi acisindan en cok kullanilan body turu
    Json oldugundan biz de ilk basta Json objesi olusturup bunu body olarak request'imize ekleyecegiz.


    JSON (JAVA SCRIPT OBJECT NOTATION) NEDIR?

    {
       "firstname" : "Eric".
       "lastname" : "Wilson",
       "totalprice" : 712,
       "depositpaid" : false
     }

     JSON formati JS ile olusturulan web uygulamalarinda data saklamak ve uygulamalar arasinda data
     alisverisi yapmak(Request/Response) icin en cok tercih edilen formattir.
     JSON formatindaki bir data icin uc temel bolum vardir.
     a. Suslu parantezler: JSON formatindaki bir datanin nerede baslayip nerede bittigini gosterir.
     Ihtiyac oldugunda NESTED(ic ice) JSON datalari olusturulabilir.

     b. Keys: JSON datalari icinde bulunan variable isimleridir.

     Keys ve Value'ler arasinda : kullanilir.
     JSON kullanildigi key-value yapisi itibari ile Java'daki Map;lere benzemektedir. API kullaniminda
     Key-Value yapisi oldugundan en cok kullanilan data yapilari Map ve JSONObject'dir.

     public void XX(){

     Map<String, Integer> ornek = new hashMap<>(){

     ornek.put("Yas", 25);
     ornek.put("Isim" "Burak");
     ornek.put("ogrenciMi", true);

     }

     public void XX(){

     JSONbject ornek = new JSONObject();
     ornek.out("Yas",25);
     ornek.put("Isim", "Burak");
     ornek.put("ogrenciMi", true);

     }

     Map olusturulurken kullanacagimiz key-value icin data turleri belirtilmek zorundadir, ancak
     JSONObject icin data turlerinin belirtilmesine gerek yoktur.

     Map olusturulurken belirttigimiz data turleri disinda data kullandigimizda Compile time error
     CTE olusur. JSONObject icin data turlerinin bir onemi yoktur, dolayisi ile kullanim acisindan
     daha esnektir.

     */
}
