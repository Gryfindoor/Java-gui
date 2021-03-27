package Day3Zad6;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;

public class Day3Zad6 {
    public static void main(String[] args)
    {
        Spiewak s1 = new Spiewak("Dietrich"){
            @Override
            String spiewaj() {
                return  "We will, we will rock you";
            }
            /*<-  kod */
        };

        Spiewak s2 = new Spiewak("Piaf"){
            @Override
            String spiewaj() {
               return  "Is this the real life?, Is this just fantasy?";
            }
            /*<-  kod */
        };

        Spiewak s3 = new Spiewak("Adele"){
            @Override
            String spiewaj() {
                return "I want to break free";
            }
            /*<-  kod */
        };

        Spiewak sp[] = {s1, s2, s3};

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}


abstract class Spiewak{

    public String nazwisko;
    private int id;
    private static int count = 0;

    public Spiewak(String nazwisko){
        this.nazwisko = nazwisko;
        count++;
        id = count;
    }


    public static String najglosniej(Spiewak[] sp) {

        int sizeSong = 0;
        Spiewak longestSong = sp[0];

        for(int x = 0; x < sp.length; x++) {
            String song = sp[x].spiewaj();
            ArrayList<Character> unique = new ArrayList<Character>();

            for (int i = 0; i < song.length(); i++)
                if (!unique.contains(song.charAt(i)))
                    unique.add(song.charAt(i));
            System.out.println(unique.size());

            if(sizeSong < unique.size()){
                sizeSong = unique.size();
                longestSong = sp[x];
            }
        }
        return longestSong.toString();
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return "(" + this.id + ") " + this.nazwisko + ": " + spiewaj();
    }
}


