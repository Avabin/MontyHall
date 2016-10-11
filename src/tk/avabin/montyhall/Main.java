package tk.avabin.montyhall;

public class Main {
    private MontyHallGameProvider montyHallGameProvider;
    private Player player1;
    private Player player2;

    private Main() {
        montyHallGameProvider = new MontyHallGameProvider();
        montyHallGameProvider.startGame(100000);

    }

    public static void main(String[] args) {
        new Main();
    }
}
