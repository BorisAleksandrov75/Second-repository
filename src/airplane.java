import java.util.Random;

public class airplane {

    Random rnd = new Random();

    private int x,y,z;
    private static int fotonum;
    private int fuel;
    private int dir = 0;
    private int r = rnd.nextInt();


    public airplane(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
    }

    public void flying(int distance) {

        if (distance > fuel) {
            distance = fuel;
        }
        fuel -= distance;

        if (dir == 0) {
            x += distance;
            y += 0;
        } else if (dir == 1) {
            x += 0;
            y += distance;
        } else if (dir == 2) {
            x -= distance;
            y += 0;
        } else if (dir == 3) {
            x += 0;
            y -= distance;
        }


    }

    public void turnRigt (){
        dir++;
        if (dir == 4) {
            dir = 0;
        }
    }

    void turnLeft () {
        dir--;
        if (dir == -1) {
            dir = 3;
        }
    }

    public void showPosition () {
        System.out.println("Your position x= " + x + ", y= " + y );
    }

}
