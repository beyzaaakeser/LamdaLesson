package Lambda;

public class Universite {

    private String univercity;
    private String bolum;
    private int ogrSayisi;
    private int notOrt;

    // parametresiz constructor
    public Universite() {
        this.univercity = univercity;
    }

    // parametreli constructor
    public Universite(String univercity, String bolum, int ogrSayisi, int notOrt) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
    }

    // getter setter
    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Lambda.Universite{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
