package Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {

        /*
           TASK :
           fields --> Lambda.Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
        */

        Universite u01 = new Universite("bogazici","matematik",571,93);
        Universite u02 = new Universite("istanbul tk","matematik",600,81);
        Universite u03 = new Universite("istanbul","hukuk",1400,71);
        Universite u04 = new Universite("marmara","bilg muh",1080,77);
        Universite u05 = new Universite("odtu","gemi muh",333,74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println("notOrt74BykUnv(unv) = " + notOrt74BykUnv(unv));
        System.out.println("matBolumuVarMi(unv) = " + matBolumuVarMi(unv));
        System.out.println("ogrSayisiByktenKcke(unv) = " + ogrSayisiByktenKcke(unv));
        System.out.println("matBolumSayisi(unv) = " + matBolumSayisi(unv));
        System.out.println("ogrSys550BykMaxNotOrt(unv) = " + ogrSys550BykMaxNotOrt(unv));
        System.out.println("ogrSys1050AzEnBykNotOrt(unv) = " + ogrSys1050AzEnBykNotOrt(unv));

    }// main


    //task 01--> Butun universitelerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv){
        return unv.stream().
                allMatch(t->t.getNotOrt() >74);
    }


    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumuVarMi(List<Universite> unv){
        return unv.stream().
                anyMatch(t-> t.getBolum().// objelerin bolum isimleri alindi
                        toLowerCase(). // bolum isimlerindeki karakterler kucuk harfer cevrildi
                        contains("mat")); // mat kelimesi var mi kontrol
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiByktenKcke(List<Universite> unv){
       return unv.stream().// akis saglandi
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).// uni'ler ogr sayisina gore tersten siralandi
                collect(Collectors.toList()); // stream yapisi list yapisina donusturuldu
    }

    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi (List<Universite> unv){
       return (int) unv.stream(). // akis saglandi
               filter(t-> t.getBolum().contains("matematik")). // matematik bolumu olan uni'leri filtreledik sectik
               count();// secilen uni sayisini aldik count terminal operatorudur.
    }


    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrSys550BykMaxNotOrt(List<Universite> unv){
        return unv.stream().
                filter(t-> t.getOgrSayisi()>550).
                mapToInt(t->t.getNotOrt()).//not ortalamalarini aldik
                max();// optional olmasinin sebebi null gelebilir. nasil null pointer gelir? universite classinda olusturduguuz variable'in
                      // default degeri olur. ama onu int yerine Integer wrapper class olsaydi null gelir.

    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrSys1050AzEnBykNotOrt(List<Universite> unv){
       return unv.stream().
               filter(t-> t.getOgrSayisi()<1050).
               mapToInt(t-> t.getNotOrt()).
               min();
    }








}//class
