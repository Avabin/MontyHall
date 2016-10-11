package tk.avabin.montyhall;

/**
 * Created by Avabin on 10.10.2016.
 */
public class Door {

    private class Reward {
    }

    private Reward reward;
    private boolean opened;

    public Door() {
        opened = false;
    }

    public void setReward() {
        this.reward = new Reward();
    }

    public boolean isRewardBehind() {
        return !(reward == null);
    }

    public void open() {
        opened = true;
    }

    public boolean isOpened() {
        return opened;
    }

    public void resetDoor() {
        reward = null;
        opened = false;
    }
}
