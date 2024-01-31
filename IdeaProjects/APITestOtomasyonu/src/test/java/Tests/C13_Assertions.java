package Tests;

public class C13_Assertions {

    /*
JUnit Assert

Response ile ilgili tum bilgileri (statusCode, contentType, headers, statusLine vb) assertThat()
metodu kullanarak yapabiliriz.

Ayni sekilde response body'de bulunan value'leri de key'leri kullanarak assert() metodundan sonra
body() metodu ve Matchers Class'ina ait metodlarla test edebiliriz.


response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Sally"),
                        "lastname", equalTo("Brown"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds",nullValue());

Assert bir test senaryosunun PASS veya FAILED durumunu belirlemede kullanilan yararli bir tontemdir.
Secilen metod va yazilan boolean kosul'a gore test sonucu belirlenir.
En cok kullandigimiz 3 Assert metodu:

1) Assert.assertTrue(kosul)
Yazilan kosul;un sonucu True ise PASS, degilse FAILED olur.

     Assert.assertTrue(20>15)---PASS
     Assert.assertTrue(10>30)---FAIL

2) AssertFalse(kosul)
Yazilan kosul'un sonucu False ise test PASS, degilse FAILED olur.

Assert.assertFalse(40>50)--->PASS
Asser.assertFalse(30>20)--->FAILED

3) Assert.assertEqual(expected, actual)

Yazilan expected ile actual esit ise test PASS, yoksa test FAILED olur.

Assert.assertEquals("Ali","Ali")


  HARD ASSERT

  Assert methodlari kullanildiginda, bir assertion FAILED olursa execution durur, test methodunun
  geri kalan kismi calismaz.
  Test case'in neden basarisiz oldugunu hemen anlamak icin hard assertionu tercih edebiliriz.

  Birden fazla assert yapiyorsak assertion basarisiz olursa, execution durur, onu duzeltip yeniden
  calistirdigimizda baska bir asertion FAILED olabilir, her seferinde bir hatayi gormus ve duzeltmis
  oluruz.Testteki hatalari duzeltmek icin bu yontem cok uygun olmayabilir.


  SOFT ASSERT
  Eger softAssert basarisiz olursa test methodunun geri kalanini durdurmaz ve yurutmeye devam eder.
  If else statement'da oldugu gibi.
  SoftAssert dogrulama(verification) olarak da bilinir.
  SoftAssert kullanabilmemiz icin object create etmemiz gerekir.

  1. adim: SoftAssert objesi olusturalim
     SoftAssert softAssert = new SoftAssert();
  2. adim: istedigimiz verificationlari yapalim.
     softAssert.assertTrue();
  3. adim: SoftAssert'in durumu raporlamasini isteyelim
     softAssert.assertAll();


   */

}
