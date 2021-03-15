package Day1Zad1;

public class MainDay1Zad1
{


    public static void main(String[] args) {

        Muzyk[] muzycy = {
                new Skrzypek("Aleks", 2),
                new Wiolonczelista("Bartek", 1),
                new Flecista("Czarek", 0.5)};

        for (Muzyk m : muzycy)
            System.out.println("Muzyk: " + m.nazwisko() + '\n' +
                    "Instrument: " + m.instrument() + '\n' +
                    "Czas wystąpienia: " + m.czas() + " godz. " + '\n' +
                    "Stawka godzinowa: " + m.stawka() + '\n');

        System.out.println(Muzyk.maxHonorarium(muzycy));


    }

    abstract static class Muzyk {

        private String nazwisko;
        private double czas;

        // konstruktor
        protected Muzyk(String nazwisko, double czas) {
            this.czas = czas;
            this.nazwisko = nazwisko;
        }

        // metoda getter
        protected String nazwisko() {
            return nazwisko;
        }

        // metoda getter
        protected double czas() {
            return  czas;
        }

        // metody abstrakcyjne
        abstract protected String instrument();
        abstract protected int stawka();


        public String toString() {
            return nazwisko +", czas = " +czas+" godz., stawka = "+stawka();

        }


        public static String maxHonorarium(Muzyk[] muzycy)
        {
        int postion = 0;
        double hightStawka = 0;
        
        for(int x = 0; x < muzycy.length; x++){
            if(muzycy[x].stawka()*muzycy[x].czas() > hightStawka){
                hightStawka = muzycy[x].stawka() * muzycy[x].czas();
                postion = x;
            }
            
        }

        return muzycy[postion].toString();

        }

    }

    static class Flecista extends Muzyk {

        public Flecista(String nazwisko, double czas) {
            super(nazwisko, czas);
        }

        @Override
        public String instrument() {
            return "Flet";
        }

        @Override
        public int stawka() {
            return 250;
        }
    }

    static class Skrzypek extends Muzyk {

        public Skrzypek(String nazwisko, double czas) {
            super(nazwisko, czas);

        }

        @Override
        public String instrument() {
            return "Flet";
        }

        @Override
        public int stawka() {
            return 250;
        }
    }

    static class Wiolonczelista extends Muzyk {

        public Wiolonczelista(String nazwisko, double czas) {
            super(nazwisko, czas);
        }

        @Override
        public String instrument() {
            return "Flet";
        }

        @Override
        public int stawka() {
            return 250;
        }
    }

}

