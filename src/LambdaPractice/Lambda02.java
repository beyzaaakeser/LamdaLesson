package LambdaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {

        List<String> list=new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println("ilkHrfBykDgrlrKck(list) = " + ilkHrfBykDgrlrKck(list));
        System.out.println("ilkHarfEVeyaC(list) = " + ilkHarfEVeyaC(list));
        yildiz(list);//*Elma* *portakal* *uzum* *cilek* *greyfurt* *nar* *mandalina* *armut* *elma* *keciboynuzu* *Ayva*
        System.out.println();
        System.out.println("eHarfliYeniList(list) = " + eHarfliYeniList(list));
        lSil(list);//Ema portaka uzum ciek greyfurt nar mandaina armut ema keciboynuzu Ayva
        System.out.println();
        ikinciHarfSiralaEnBykYaz(list); // Optional[keciboynuzu]


    }//main

    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim
    public static List<String> ilkHrfBykDgrlrKck(List<String> list){
        return list.stream().
                map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
                collect(Collectors.toList());
    }

    // S2: ilk harfi e ve ya c olanlari listeleyelim
    public static List<String> ilkHarfEVeyaC(List<String> list){
        return list.stream().filter(t-> t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).collect(Collectors.toList());
    }

    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yildiz(List<String> list){
        list.stream().map(t-> "*"+t+"*").forEach(Utils::yazdirString);
    }

    //S4 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eHarfliYeniList(List<String> list){
        return list.stream().filter(t-> t.toLowerCase().contains("e")).collect(Collectors.toList());
    }

    //S5: tum 'l' leri silelim yazdiralim
    public static void lSil(List<String> list){
        list.stream().map(t->t.replaceAll("l","")).forEach(Utils::yazdirString);
    }

    //S6: List elemanarını 2.harfe gore sıralayıp
    //ilk 5 elemandan char sayısı en buyuk elemanı print

    public static void ikinciHarfSiralaEnBykYaz(List<String> list){
        System.out.println(list.stream().
                sorted(Comparator.comparing(t -> t.charAt(1))). // List elemanlarini ikinci harfe gore siraladik
                        limit(5). // ilk 5 eleman olarak limit belirledik akisa devam etti
                        sorted(Comparator.comparing(String::length).reversed()). // uzunluguna gore siraladik, sonra en uzun eleman basa gelsin diye siralamayi reversed ile terse cevirdik
                        findFirst());// akistan gelen ilk elemani bize verir

    }
















}//class
