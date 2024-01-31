package Tests;

public class POJO_CLASSES {
 /*

 API test otomoasyonunda Request ve Response icin kullanilabilecek yapilar:
 1. JsonPath yardimi ile json objesi
 2. De-Serialization ile Map kullanimi
 3. Pojo Class kullanimi
 4. Obje Mapper Kullanimi

 Pojo: Plain Old Java Object(Basit Java objesi)
 Komplex request veya response body'lerini olusturmak uzun islem gerektirebilir.
 daha once yaptigimiz orneklerde TestData classlari olusturmus ve tum datalarimizi
 bu classlarda toplamistik.
 Pojo kullaniminda her bir Json Objesi icin method degil class olusturacagiz.
 Pojo kullaniminda Java'daki ENCAPSULATION ozellikleri kullanilir.
 Kompleks Json objeleri icin otomatik olarak Pojo Class'lari olusturan Web-sitelerinden
 yardim alabiliriz. Pojo classlari 3 sekilde olusturabiliriz:
 1.JsonSchema2pojo'dan faydalanabiliriz.

 2. dependencilerden yararlanabiliriz.
 pojo class'imizin uzerine
 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 'lar eklenirse lombok sayesinde setter(), getter()vs olusturmamiza gerek kalmaz,sadece variableleri yazariz.

 <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.22</version>
    </dependency>

3. Basit yapidaki Json objeleri icin kendimiz de Pojo Class'lari olusturabiliriz.


  */
//    pojo class olusturmak icin su 5 adimi izlemeliyiz:
// 1.tum variable'leri private olusturalim
// 2.tum variable'ler icin getter ve setter metodlari olusturalim
// 3.tum parametreleri kullanarak bir constructor olusturalim
// 4.default constructor yerine manuel olarak parametresiz bir constructor olusturalim
// 5.toString metodu olusturalim
}
