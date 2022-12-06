package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi); //16 4 36
        System.out.println();
        tekKupPrint(sayi); // 1332 -124 344 28 3376
        System.out.println();
        maxElBul(sayi); // Optional[15]
        // bu arada max = -2147483648 var
        structuredMaxElBul(sayi);//En buyuk sayi : 15
        ciftKareMaxPrint(sayi); // Optional[36]
        elTopla(sayi); // toplam = 43
        ciftCarp(sayi); // Optional[48]
        minBul(sayi); // Optional[-5]
        bestenBuyukEnKucuk(sayi); // Optional[7]
        ciftKareKbSortPrint(sayi); // 4 16 36

    }// main


    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    //          ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul). // akistaki cift sayilari filtreledim 4,2,6
                map(t-> t*t). // methodu akisi degistirir. stream icerisindeki elemanlari baska degerlere donusturur. 16,4,36 yeni bir stream. yukaridakine gore degisti artik
                forEach(Lambda01::yazdir); //
    }

    // Task 2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin
    public static void tekKupPrint(List<Integer> sayi){
        sayi.
                stream(). //(4,2,6,11,-5,7,3,15)
                filter(t-> t%2!=0). // 11 -5 7 3 15
                map(t->(t*t*t)+1).
                forEach(Lambda01::yazdir);// 1332 -124 344 28 3376
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    //          karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekokPrint (List<Integer> sayi){
       sayi.
               stream().
               filter(Lambda01::ciftBul).
               map(Math::sqrt). // double dondurur. hazir karekok alma methodudur.
               forEach(t-> System.out.println(t+" ")); // bu birinci yol
    }


    // Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi){
        Optional<Integer> maxSayi = sayi.       // optional java 8 ile dunyamiza giren seylerden biri daha.
                stream().
                reduce(Math::max); // eger benim result'im tek bir deger ise o zaman reduce terminal operatoru kullanilir. bos kume olursa NullPointerException atar.Mesela bir sinavda 50 ustunde alanlarin en yuksegini bana ver desek. ama herkes 50nin altinda aldiysa bos kume olur ve nullpointerexception verir
        System.out.println(maxSayi); //
    }

    // structered yapi ile yazalim
    public static void structuredMaxElBul(List<Integer> sayi){
        int max= Integer.MIN_VALUE;
        System.out.println("max = " + max); // max.soutv yainca otomatik bu hale getiriyo max = -2147483648
        for (int i = 0; i <sayi.size() ; i++) {
            if (sayi.get(i)>max) max= sayi.get(i); // if conditional tek satirsa suslu paranteze gerek yok
        }
        System.out.println("En buyuk sayi : "+ max); // En buyuk sayi : 15
    }


    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftKareMaxPrint(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max)); // Integer::max methodu Math::max'a gore daha hizli calisir.. Math::max daha geniş olduğu için digerine gore yavas calisir
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void elTopla(List<Integer> sayi){
        int toplam = sayi.stream().reduce(0,(a,b)-> a+b);
        System.out.println("toplam = " + toplam); //toplam = 43
    }

    /*
         a ilk degerini her zaman atanan degerden (ilk parametre) alır,
         bu örnekte 0 oluyor cunku toplamin etkisiz elemani 0. carpma olsaydi 1 diyecektik
         b degerini her zamana  stream()'dan akısdan alır
         a ilk degerinden sonraki her değeri action(işlem)'dan alır
    */


    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer> sayi){
        System.out.println(sayi.
                            stream().
                            filter(Lambda01::ciftBul).
                            reduce(Math::multiplyExact)); // Optional[48] burada method reference kullandik

        System.out.println(sayi.
                            stream().
                            filter(Lambda01::ciftBul).
                            reduce(1, (a, b) -> a * b)); // 48 lamda expression kullandik.

    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer> sayi){
        System.out.println(sayi.stream().reduce(Integer::min)); // Optional[-5]  ==>  1.yol

        System.out.println(sayi.stream().reduce(Lambda02::byMiracMin)); // Optional[-5]  ==>  2.yol
    }

    public static int byMiracMin(int a , int b){
        return a<b ? a : b;
    }


    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBuyukEnKucuk(List<Integer> sayi){
        System.out.println(sayi.stream().filter(t -> (t > 5) && (t % 2 == 1)).reduce(Lambda02::byMiracMin));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbSortPrint(List<Integer> sayi){
        sayi.
                stream(). // akisi baslattik
                filter(Lambda01::ciftBul). // akis icindeki cift sayilari aldim
                map(t-> t*t).// sayilarin karesi ile yeni bir akis olusturdum
                sorted().// akis icindeki sayilari natural order olarak siraladim
                forEach(Lambda01::yazdir); // akisdaki sayilari ekrana yazdim 4 16 36
    }

}//class




