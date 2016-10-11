package tk.avabin.montyhall;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Avabin on 10.10.2016.
 */
public class Player {
    private int ID;
    private int winCounter;
    private Random random;
    private String prefix;
    private boolean stay;
    private ArrayList<Door> doors;
    private Door choosenDoor;

    public Player(int ID, ArrayList<Door> doors, boolean stay) {
        random = new Random();
        this.ID = ID;
        prefix = "Player_" + ID + ": ";
        System.out.println(prefix + "Hello! I'm player " + ID + ".");
        this.doors = doors;
        this.stay = stay;

    }

    public void chooseDoor() {
        choosenDoor = doors.get(random.nextInt(doors.size()));
        System.out.println(prefix + "I'll choose that door.");
    }

    public void switchOrStay() {
        if (!stay) {
            System.out.println(prefix + "I'll switch.");
            while (true) {
                int temp = random.nextInt(3);
                if (!doors.get(temp).equals(choosenDoor) && !doors.get(temp).isOpened()) {
                    choosenDoor = doors.get(temp);
                    break;
                }
            }

        } else {
            System.out.println(prefix + "I'll stay.");
        }
    }

    public Door getChosenDoor() {
        return choosenDoor;
    }

    public void increaseWinCounter() {
        System.out.println(prefix + "Yay! I won!");
        winCounter++;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public int getID() {
        return ID;
    }
}
