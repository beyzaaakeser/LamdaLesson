package LambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice01 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        // S1:listi aralarinda bosluk birakarak yazdiriniz

        hepsiniYazdir(list);
        System.out.println();
        //S2: sadece negatif olanlari yazdir
        negatifYazdir(list);
        System.out.println();

        //S3: cift olanlari yeni olustur
        ciftYaz(list);
        System.out.println();

        //S4:pozitif ve çift olanları yazdırın
        pozVeCift(list);
        System.out.println();

        //Pozitif veya cift
        pozVeyaCift(list);
        System.out.println();


        //S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
        //map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
        //ıslem yapmak ıcın (update) kullanılır
        kareYazdir(list);
        System.out.println();

        //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
        ciftKup(list);
        System.out.println();

        //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım
        kareTekrarsiz(list);
        System.out.println();
        // distinct() methodunun sorusu. method kismini oku !!!!


        //S9: listin elemanlarini kucukten buyuge siralayalim
        kucuktenBuyuge(list);
        System.out.println();

        //S10: listin elemanlarini buyukten kucuge siralayalim
        buyuktenKucuge(list);
        System.out.println();
        // sorted methodunu parametreli kullandik. parametreye Comparator.reverseOrder() koyduk. reverse tersten demek. !!!!!

        // terminal method akisi sonlandiran methodlardir return type'i stream olmayan yani akisi dondurmeyen methodlardir.
        // ara methodlar akisi donduren methodlardir. return type'i stream akisi donduren methodlardir.


        // S11: list pozitif elemanlari icin kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
        System.out.println("pozKup5List(list) = " + pozKup5List(list));
        pozKup5List2(list); // bunu souta almadik cunku methodda bu kez sout demistik

        //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
        System.out.println("pozKareSon5DegilList() = " + pozKareSon5DegilList(list));

        // S13 :list elemanlarini toplamini bulalim
        toplam(list);

        /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
        */

        System.out.println("elToplamReferenceInt(list) = " + elToplamReferenceInt(list));
        System.out.println("elToplamReference(list) = " + elToplamReference(list));


        //S14 : Listin pozitif elemanları toplamını bulalım
        pozElToplam(list); // 61


    }

    public static void hepsiniYazdir(List<Integer>l){
        l.stream().forEach(t-> System.out.print(t+" "));
    }


    public static void negatifYazdir(List<Integer>l){
        l.stream().filter(t->t<0).forEach(t-> System.out.print(t+" "));
    }

    public static void ciftYaz(List<Integer>l){
        l.stream().filter(t-> (t&2)==0).forEach(t-> System.out.print(t+" "));
    }

    public static void pozVeCift(List<Integer>l){
        l.stream().filter(t-> t>0 && t%2==0).forEach(t-> System.out.print(t+" "));
    }

    public static void pozVeyaCift(List<Integer>l){
        l.stream().filter(t-> t%2==0 || t>0).forEach(t-> System.out.print(t+" "));
    }

    public static void kareYazdir(List<Integer> l){
        l.stream().map(t-> t*t).forEach(t-> System.out.print(t+" "));
    }

    public static void ciftKup(List<Integer> l){
        l.stream().filter(t-> t %2 ==0).map(t-> t*t*t).forEach(t-> System.out.print(t+" "));
    }

    public static void kareTekrarsiz(List<Integer> l){
        l.stream().map(t-> t*t).
                distinct().// methodu akistan gelen elemanlari benzersiz tekrarsiz sekilde yazdiriyor
        forEach(t-> System.out.print(t+" "));

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    public static void kucuktenBuyuge(List<Integer> l){
        l.stream().sorted().forEach(t-> System.out.print(t+" "));

    }

    public static void buyuktenKucuge(List<Integer> l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" ")); // comparator classindan cagiriyoruz bu nedenle
        // reversi comparator ile kullanmak sart
    }

    public static List<Integer> pozKup5List(List<Integer> l){
       return l.stream().filter(t-> t>0).map(t-> t*t*t).filter(t-> t%10==5).
                collect(Collectors.toList());// terminal methoddur ve list dondurur.

    }

    public static void pozKup5List2(List<Integer> l){
       List<Integer> list =  l.stream().filter(t-> t>0).map(t-> t*t*t).filter(t-> t%10==5).
                collect(Collectors.toList());// terminal methoddur ve list dondurur.
        System.out.println(list);
    }
    public static List<Integer> pozKareSon5DegilList(List<Integer> l){
        return l.stream().filter(t-> t>0).map(t-> t*t).filter(t->t%10!=5).collect(Collectors.toList());
    }

    public static void toplam(List<Integer> l){
        int sum = l.stream().reduce(0,(a,b)-> a+b); // reduce terminal methodudur
        System.out.println(sum);

    }

    public static int elToplamReferenceInt(List<Integer> l){
        int i = l.stream().reduce(0,Integer::sum);
        return i;
    }

    public static int elToplamReference(List<Integer> l){
        int i = l.stream().reduce(0,Math::addExact);
        return i;
    }

    public static void pozElToplam(List<Integer> l){
        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Integer::sum));

    }




}
