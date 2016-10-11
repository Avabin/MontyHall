package tk.avabin.montyhall;


import java.util.ArrayList;
import java.util.Random;

/**
 * Class for simulating player behaviour.
 */
public class Player {
    private int ID;
    private int winCounter;
    private Random random;
    private String prefix;
    private boolean stay;
    private ArrayList<Door> doors;
    private Door choosenDoor;

    /**
     * Class constructor responsible for player object setup.
     * @param ID ID of the player.
     * @param doors ArrayList of doors
     * @param stay boolean value determining player behaviour. If true, player will not switch door when asked to.
     */
    public Player(int ID, ArrayList<Door> doors, boolean stay) {
        random = new Random();
        this.ID = ID;
        prefix = "Player_" + ID + ": ";
        System.out.println(prefix + "Hello! I'm player " + ID + ".");
        this.doors = doors;
        this.stay = stay;

    }

    /**
     * Choose door method.
     */
    public void chooseDoor() {
        choosenDoor = doors.get(random.nextInt(doors.size()));
        System.out.println(prefix + "I'll choose that door.");
    }

    /**
     * Switch or Stay behaviour. When _stay_ boolean is true, player will NOT switch door when this method is called.
     */
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

    /**
     * Chosen door getter.
     * @return reference to door chosen by player.
     */
    public Door getChosenDoor() {
        return choosenDoor;
    }

    /**
     * In case player won, this method is called, increasing the win counter and making player happy :)
     */
    public void increaseWinCounter() {
        System.out.println(prefix + "Yay! I won!");
        winCounter++;
    }

    /**
     * Win counter getter.
     * @return win counter.
     */
    public int getWinCounter() {
        return winCounter;
    }

    /**
     * ID getter.
     * @return ID of player
     */
    public int getID() {
        return ID;
    }
}
