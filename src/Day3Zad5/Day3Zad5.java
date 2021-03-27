package Day3Zad5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day3Zad5 {
    public static void main(String[] args) {

        List<Figura> listaFig = new ArrayList<Figura>();


        System.out.println("Figury przed sortowaniem:");

        listaFig.add(new Kolo(20,20,30));
        listaFig.add(new Prostokat(20,20,30,10));
        listaFig.add(new Prostokat(20,20,30,10));
        listaFig.add(new Kolo(20,20,30));
        listaFig.add(new Kolo(50,90,10));
        listaFig.add(new Prostokat(20,20,30,10));

        for (Figura f : listaFig) {
            System.out.println(f);
        }
        Collections.sort(listaFig, Collections.reverseOrder());

        System.out.println("Figury po sortowaniu:");
        for (Figura f : listaFig) {

            System.out.println(f);


        }

    }
}

abstract class Figura implements Obliczenie,Comparable<Figura> {

    protected int x;
    protected int y;
    private int id;
    private static int count = 0;

    // konstruktor
    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
        count++;
        id = count;
    }

    // metody abstrakcyjne
    public abstract String fig();

    public abstract String pozycja(int x, int y);

    public int getId() { return id; }

    @Override
    public String toString() {
        return fig();
    }


    public abstract double pole();


    public abstract double obwód();

    @Override
    public int compareTo(Figura f) {
        // obiekty this, f
//        System.out.println(f.pole());
//        System.out.println(this.pole());

        if (this.pole() - f.pole() < 0) {
            return -1;
        } else {
            if (this.pole() > f.pole()) {
                return 1;
            }else if(this.pole() == f.pole()){
                if(this.obwód() > f.obwód()){
                    return 1;
                }else {
                   return -1;
                }
            }
            if(this.getId() > f.getId()){
                return 1;
            }
            return -1;
        }

    }

}

    class Kolo extends Figura implements Obliczenie {

        private int promien;

        // konstruktor
        public Kolo(int x, int y, int r) {
            super(x, y);
            this.promien = r;
        }

        @Override
        public String fig() {
            return "Koło";
        }

        @Override
        public String pozycja(int x, int y) {
            boolean heler = false;
            String isEqueal = "";


            if (x - promien <= this.x && y - promien <= this.y) {
                heler = true;
            }

            if (heler) {
                isEqueal = "wewnątrz";
            } else {
                isEqueal = "na zewnątrz";
            }

            return "Punkt (" + x + "," + y + ") " + "znajduje się " + isEqueal + " koła" + "\n";
        }

        @Override
        public String toString() {
            return super.toString() + "\nŚrodek - (" + x + ',' + y + ")" + "\nPromień: " + promien + "\n";
        }

        @Override
        public double obwód() {
            return (2 * Math.PI * promien);
        }

        @Override
        public double pole() {
            return (Math.pow(promien, 2) * Math.PI);
        }
    }

    class Kolo2 extends Kolo implements Transformacja {

        private int helperx, helpery;

        public Kolo2(int x, int y, int r) {
            super(x, y, r);
        }

        @Override
        public void przesunDo(int x, int y) {
            helperx = this.x;
            helpery = this.y;

            this.x = x;
            this.y = y;

        }

        @Override
        public void powrot() {
            x = helperx;
            y = helpery;
        }


    }

    class Prostokat extends Figura implements Obliczenie {

        protected int szer, wys;

        // konstruktor
        public Prostokat(int x, int y, int s, int w) {
            super(x, y);

            this.szer = s;
            this.wys = w;
        }

        @Override
        public String fig() {
            return "Prostokat";
        }

        @Override
        public String pozycja(int x, int y) {
            boolean heler = false;
            String isEqueal = "";

            if ((this.x <= x && x <= this.x + szer) && (this.y >= y && this.y - wys <= y)) {
                heler = true;
            }

            if (heler) {
                isEqueal = "wewnątrz";
            } else {
                isEqueal = "na zewnątrz";
            }

            return "Punkt (" + x + "," + y + ") " + "znajduje się " + isEqueal + " prostokąta" + "\n";
        }

        @Override
        public String toString() {
            return super.toString() + "\nLewy górny - (" + x + ',' + y + ")" + "\nSzerokość: " + szer + ", " + "Wysokość: " + wys + "\n";
        }

        @Override
        public double pole() {
            return (szer * wys);
        }

        @Override
        public double obwód() {
            return (2 * szer + 2 * wys);
        }
    }

    class Prostokat2 extends Prostokat implements Rysowanie {

        public char c;


        public Prostokat2(int x, int y, int s, int w, char c) {
            super(x, y, s, w);
            this.c = c;
        }

        @Override
        public void rysuj() {
            for (int x = 0; x < wys; x++) {
                for (int y = 0; y < szer; y++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

    interface Obliczenie {
        public double obwód();

        public double pole();
    }

    interface Rysowanie {
        public void rysuj();
    }

    interface Transformacja {

        public void przesunDo(int x, int y);

        public void powrot();
    }

