package Day2Zad4;

public class MainDay2Zad4 {
    public static void main(String[] args){

        Figura fig[] = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);                    // położenie koła = srodek = (10,10), promień = 5
        fig[1] = new Prostokat(20, 20, 15, 10);    // położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10

        // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
        // a nie z klasy Figura
        for (Figura f : fig)              // pętla for-each
            System.out.println(f.toString());    // System.out.println(f.toString());

        System.out.println(fig[0].pozycja(12, 12));
        System.out.println(fig[1].pozycja(25, 3));


        System.out.println(fig[1].pole());
        System.out.println(fig[0].obwód());


    }
}
abstract class Figura implements Obliczenie {

    protected int x;
    protected int y;

    // konstruktor
    public Figura(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // metody abstrakcyjne
    public abstract String fig();
    public abstract String pozycja(int x, int y);


    @Override
    public String toString()
    {
        return fig();
    }

    @Override
    public int pole() {
        return 0;
    }

    @Override
    public int obwód() {
        return 0;
    }
}

class Kolo extends Figura implements Obliczenie {

    private int promien;

    // konstruktor
    public Kolo(int x, int y, int r)
    {
        super(x,y);
        this.promien = r;
    }

    @Override
    public String fig() {
        return "Koło";
    }

    @Override
    public String pozycja(int x, int y)
    {
        boolean heler = false;
        String isEqueal = "";


        if(x-promien <= this.x && y-promien <= this.y){
            heler = true;
        }

        if(heler){
            isEqueal = "wewnątrz";
        }else{
            isEqueal = "na zewnątrz";
        }

        return "Punkt ("+x+","+y+") "+"znajduje się "+isEqueal+" koła" + "\n";
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nŚrodek - (" + x + ',' + y + ")" + "\nPromień: " + promien + "\n";
    }


}

class Prostokat extends Figura implements Obliczenie {

    protected int szer, wys;

    // konstruktor
    public Prostokat(int x, int y, int s, int w)
    {
        super(x, y);

        this.szer = s;
        this.wys = w;
    }

    @Override
    public String fig() {
        return "Prostokat";
    }

    @Override
    public String pozycja(int x, int y)
    {
        boolean heler = false;
        String isEqueal = "";

        if((this.x <= x && x <= this.x+szer) && (this.y >= y && this.y-wys <= y)){
            heler = true;
        }

        if(heler){
            isEqueal = "wewnątrz";
        }else{
            isEqueal = "na zewnątrz";
        }

        return "Punkt ("+x+","+y+") "+"znajduje się "+isEqueal+" prostokąta" + "\n";
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nLewy górny - (" + x + ',' + y + ")" + "\nSzerokość: " + szer + ", " + "Wysokość: " + wys + "\n";
    }

}

interface Obliczenie{
    public  int obwód();
    public  int pole();
}