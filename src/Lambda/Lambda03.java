package Lambda;

import Lambda.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trilece","havucDilim","guvec","kokorec","kusleme","arabAsi","waffle","kunefe","guvec"));
        alfBykTekrsz(menu);
        System.out.println();
        karakterTers(menu);
        System.out.println();
        chrKckBykPrint(menu);
        System.out.println();
        harfSayisi7denAzKontrol(menu);
        wIleBaslama(menu);
        xIleBiten(menu);
        chrSayisiEnByk(menu);
        task8(menu);
    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrsz(List<String> yemek) {
        yemek.stream(). // akis basladi
                map(String::toUpperCase).//buyuk harfe cevirme yaptik
                sorted().// siraladik alfabetk siraya sokacak. dogal siralama
                distinct().// akistan gelen elemanlari tekrarsiz sekilde yazdirmak icin kullanilir
                forEach(t -> System.out.print(t + " ")); //print
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karakterTers(List<String> yemek){
       yemek.stream(). // akis alindi
               map(String::length). // akisi guncelledik kelimelerin uzunlugu olarak
               sorted(Comparator.reverseOrder()). // ters sirali
               distinct().// tekrarsiz
               forEach(Lambda01::yazdir); // print
    }

    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..
    public static void chrKckBykPrint(List<String> yemek){
        yemek.stream(). // akis saglandi
                sorted(Comparator.comparing(String::length)). // String ifadeleri karakter sayisina gore kucukten buuge siraladik
                                                              // akistan gelen string ifadeleri updaate etmeden karakter sayisina gore print etmek dogal sira olacagi icin
                                                              // Stringin uzunluguna gore dogal siralamayi kucukten buyuge yap dedik
                forEach(Lambda01::yazdir); // print ettik
    }







    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.







    // Task-4 : List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol(List<String> yemek){
        System.out.println(yemek.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha az harften olusuyor" :
                "List elemanlari 7 harften buyuk");
    }


    // Task-5 : List elemanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void wIleBaslama(List<String> yemek){
        System.out.println(yemek.stream().noneMatch(t -> t.startsWith("w")) ? "W ile yemek ismi mi olur" : "w ile yemek icat ettik");
    }


    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBiten(List<String> yemek){
        System.out.println(yemek.stream().anyMatch(t -> t.endsWith("x")) ? "masallah" : "X ile biten yemek ismi mi olur");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void chrSayisiEnByk(List<String> yemek){
        Stream<String> buyukEl = yemek.stream().// akis saglandi
                sorted(Comparator.comparing(t-> t.toString().length()).reversed()). // karakter sayisina gore tersten siraladik ki en buyuk eleman ilk siraya gelsin
                limit(1); // limit methodunun donen degeri Stream<String> yapidadir limit belirledik. sadece ilk elemani cagirdik kac girersek oraya akistaki o kadar elemani getir demis oluruz

        System.out.println(Arrays.toString(buyukEl.toArray()));
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void task8(List<String> yemek){
        yemek.stream().// akis saglanda
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))). // son harfine gore alfabetik sira
                skip(1).// akistaki ilk eleman haric tutuldu
                forEach(Lambda01::yazdir); // ekrana print edildi
    }

    //











}//class
