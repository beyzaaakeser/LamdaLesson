package Lambda;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("topla(5) = " + topla(5));
        System.out.println("toplaCincix(5) = " + toplaCincix(5));
        System.out.println("ciftToplam(6) = " + ciftToplam(5));
        System.out.println("ilkXCiftSayiToplam(4) = " + ilkXCiftSayiToplam(4));
        System.out.println("ilkXTekSayiToplam(3) = " + ilkXTekSayiToplam(3));
        ikininIlkXKuvveti(3);
        System.out.println();
        istenenIlkXKuvveti(3,2);
        System.out.println();
        System.out.println("faktoriyel(5) = " + faktoriyel(5));
    }



    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    // structured
    public static int topla(int x){
        int toplam = 0;
        for (int i = 0 ; i<=x ; i++){
            toplam= toplam+i;
        }
        return toplam;
    }


    // functional
    public static int toplaCincix(int x){
        return
        IntStream.// otomatik olarak bize integer akis sagliyor parantez icine sanki (List<Integer> x) yazmisim gibi yapiyor.
        range(1,x+1). // buraya girdigim sayidan itibaren aliyor ilki dahil ikinci haric. soruda x de dadhil olsun dedigi icin x+1 dedik.
        sum();
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftToplam(int x){
        return
                IntStream.rangeClosed(1,x).
                        filter(Lambda01::ciftBul).
                        sum();
    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilkXCiftSayiToplam(int x){
        return IntStream.
                iterate(2,t->t+2). // 2 den baslar 2 artirarak sonsuza kadar gider
                limit(x). // burada durdurma yaptik xe kadar olan ciftleri toplayacak
                sum(); // akisdan gelen butun elemanlari topluyor
    }


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXTekSayiToplam(int x){
        return IntStream.
                iterate(1,t->t+2). // 1 den baslar 2 artirarak sonsuza kadar gider
                        limit(x). // burada durdurma yaptik xe kadar olan tekleri toplayacak
                        sum(); // akisdan gelen butun elemanlari topluyor
    }


    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvveti(int x){
         IntStream.
                 iterate(2,t->t*2). // iterason icin sart yazdik
                 limit(x). // x degeri ile sinirladik
                 forEach(Lambda01::yazdir); // lambda01 classindaki yazdir methodunu cagirarak ekrana yazdik
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenIlkXKuvveti(int istenenSayi,int x){
        IntStream.iterate(istenenSayi,t->t*istenenSayi).limit(x).forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int faktoriyel(int x){
        return IntStream.
                rangeClosed(1,x). //
                reduce(1,(t,u)->t*u);
    }









}
