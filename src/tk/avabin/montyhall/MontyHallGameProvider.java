package tk.avabin.montyhall;


import java.util.ArrayList;
import java.util.Random;

/**
 * Monty Hall's game provider
 */
public class MontyHallGameProvider {
    private ArrayList<Door> doors;
    private Random random = new Random();
    private Player player1, player2;
    private Door rewardDoor;

    /**
     * Constructor responsible for creating players and doors.
     */
    public MontyHallGameProvider() {
        System.out.println("Welcome in my game! Greetings to our players!");
        doors = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            doors.add(new Door());
        }

        player1 = new Player(1, doors, true);
        player2 = new Player(2, doors, false);
    }

    /**
     * Start game method. Playing rounds for both players.
     *
     * @param rounds For each player, there will be _rounds_ number of rounds.
     */
    public void startGame(int rounds) {
        for (int i = 0; i < rounds; i++) {
            System.out.println("Round " + (i + 1) + "\n");
            round(player1);
            round(player2);
        }

    }

    /**
     * Method for setting and resetting doors. For each door, there is a method called
     * from each door object, to reset that door.
     *
     * @see Door
     */
    private void setDoors() {
        doors.forEach(Door::resetDoor);
        doors.get(random.nextInt(3)).setReward();
    }

    /**
     * Openning one door with NO reward and NOT chosen by specified player.
     *
     * @param player player with a door chosen.
     * @see Player
     * @see Door
     */
    private void openDoorNotChosenByPlayer(Player player) {
        while (true) {
            int temp = random.nextInt(3);
            if (!doors.get(temp).equals(rewardDoor) && !doors.get(temp).equals(player.getChosenDoor())) {
                doors.get(temp).open();
                break;
            }
        }
    }

    /**
     * Playing a one round with simulation of Game Master speech with System.out.println().
     * @param player player for which round will be played.
     */
    private void round(Player player) {
        setDoors();
        doors.stream().filter(Door::isRewardBehind).forEach(door -> rewardDoor = door);
        System.out.println("Here you have 3 doors. There is hidden reward just behind one of it. Choose one door.");
        player.chooseDoor();
        System.out.println("Ok. Now, I'm opening one of the door without reward.");
        openDoorNotChosenByPlayer(player);
        System.out.println("So, do you switch or stay?");
        player.switchOrStay();
        System.out.println("Ok. Let's check if you won.");

        if (rewardDoor.equals(player.getChosenDoor())) {
            System.out.println("You won!");
            player.increaseWinCounter();
        }

        System.out.println("Player_" + player.getID() + ": \n" +
                "won:  " + player.getWinCounter() + "\n");

    }
}
