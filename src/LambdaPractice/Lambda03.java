package LambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda03 {

    public static void main(String[] args) {

        Apartman daire1=new Apartman("dogu",3,4000);
        Apartman daire2=new Apartman("bati",2,2500);
        Apartman daire3=new Apartman("guney",1,3500);
        Apartman daire4=new Apartman("dogu",5,3000);

        List<Apartman> kiralikDaireler=new ArrayList<>(Arrays.asList(daire1,daire2,daire3,daire4));
        kiraSirala(kiralikDaireler);
        System.out.println("katSayisiSirala(kiralikDaireler) = " + katSayisiSirala(kiralikDaireler));


    }
    //dogu cephesindeki kiralık daireleri kiralarına göre sıralayın
    public static void kiraSirala(List<Apartman> daire){
         daire.stream().
                 filter(t -> t.getCephe().equalsIgnoreCase("dogu")). // cephesi dogu olan daireleri filtreledik
                 sorted(Comparator.comparing(Apartman::getKira)).// kiralara gore ssiraladik
                 forEach(System.out::println);

    }

    //kat sayısı 2den cok olan dairelerin kiralarını listeleyın
    public static List<Integer> katSayisiSirala(List<Apartman> daire){
        return daire.stream().filter(t-> t.getKatSayisi()>2).map(t->t.getKira()).collect(Collectors.toList());
    }











}
