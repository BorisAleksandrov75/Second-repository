import java.util.Arrays;
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

    public String encriptoCeaser () {
        String alfavit = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
        fotonum++;

        String enterkey = "YOUR_POSITION_AND_NUMBER_X" + x + "_Y" + y + "_N" + fotonum;
        int[] numshifr = new int[enterkey.length()];

        for (int j = 0; j < enterkey.length(); j++) {
            for (int k = 0; k < alfavit.length(); k++) {
                if (alfavit.charAt(k) == enterkey.charAt(j)) {
                    numshifr[j] = k + r;
                    if (numshifr[j] > 37) {
                        numshifr[j] -= 37;
                    }
                }
            }
        }
        return Arrays.toString(numshifr);
    }

    public void decrupto () {
        String[] alfavit = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                "O","P","Q","R","S","T","U","V","W","X","Y","Z","_","0","1","2","3"
                ,"4","5","6","7","8","9"};

        String a = encriptoCeaser();
        String[] decripttext = a.replace(" ","").replace("[","").replace("]","").split(",");
        String[] result = new String[decripttext.length];

        for (int i = 0; i < decripttext.length; i++) {
            if (Integer.parseInt(decripttext[i]) - r < 0) {
                result[i] = alfavit[Integer.parseInt(decripttext[i]) - r + 37];
            } else {
                result[i] = alfavit[Integer.parseInt(decripttext[i]) - r];
            }
        }

        System.out.println(Arrays.toString(result));
    }

}
