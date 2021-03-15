package Day1Zad2;

public class MainDay1Zad2 {

    public static void main(String[] args) {


		Flyable f[] = {new Bird(2,"Wings", "CwirrrrCwirrrr.."),
                new UFO(400,"Flying Saucer", "BlablaBla.."),
                new Plane(100, "Engine", "Frrrrrr.."),
        new Virus(205, "Cloud")};
		Speakable s[] = {new Bird(25, "Wigs", "CwirrrrCwirrrr.."),
                new Plane(100, "Engine","Frrrrrr..Frrrrrr..Frrrrrr.."),
		        new UFO(340, "Flying Saucer", "BlaBlaBlaaaa..")
		};



		System.out.println(shortest(f).distance());
		System.out.println(loudest(s).speak());



    }


	private static Flyable shortest(Flyable[] f) {
        int x = f.length-1;
        Flyable shortestPostion = f[0];

		while(x > 0){
            if(shortestPostion.distance() > f[x].distance()){
                shortestPostion = f[x];
            }
            x--;
        }

		return shortestPostion;
	}



	private static Speakable loudest(Speakable[] s) {
        int x = s.length-1;
        Speakable loudestPostion = s[0];

        while(x > 0){
            if(loudestPostion.speak().length() < s[x].speak().length()){
                loudestPostion = s[x];
            }
            x--;
        }

        return loudestPostion;
	}


}
interface Flyable {

    public double distance();
    public String drive();

}

interface Speakable {
    public String speak();
}

class Bird implements Flyable, Speakable{
    double distance;
    String drive;
    String speak;

    //...
    public Bird(double distance, String drive, String speak){
       this.distance =distance;
       this.drive = drive;
       this.speak = speak;


    }

    @Override
    public String speak() {
        // TODO Auto-generated method stub
        return speak;
    }

    @Override
    public double distance() {
        // TODO Auto-generated method stub
        return distance;
    }

    @Override
    public String drive() {
        // TODO Auto-generated method stub
        return drive;
    }

}

class Virus implements Flyable {

    double distance;
    String drive;


    public Virus(double distance, String drive){
        this.distance =distance;
        this.drive = drive;
    }

    @Override
    public double distance() {
        // TODO Auto-generated method stub
        return distance;
    }

    @Override
    public String drive() {
        // TODO Auto-generated method stub
        return drive;
    }

}


class UFO implements Flyable, Speakable{

    double distance;
    String drive;
    String speak;

    public UFO(double distance, String drive, String speak){
        this.distance = distance;
        this.drive = drive;
        this.speak =speak;
    }

    @Override
    public String speak() {
        // TODO Auto-generated method stub
        return speak;
    }

    @Override
    public double distance() {
        // TODO Auto-generated method stub
        return distance;
    }

    @Override
    public String drive() {
        // TODO Auto-generated method stub
        return drive;
    }

}

class Plane implements Flyable, Speakable{

    //...

    double distance;
    String drive;
    String speak;

    public Plane(double distance, String drive, String speak){
        this.distance = distance;
        this.drive = drive;
        this.speak = speak;
    }

    @Override
    public String speak() {
        // TODO Auto-generated method stub
        return speak;
    }

    @Override
    public double distance() {
        // TODO Auto-generated method stub
        return distance;
    }

    @Override
    public String drive() {
        // TODO Auto-generated method stub
        return drive;
    }

}


