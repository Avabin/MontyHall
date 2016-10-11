package tk.avabin.montyhall;

/**
 * Door class
 */
public class Door {

    /**
     * Empty Reward class for simullating reward behind ona of doors.
     */
    private class Reward {
    }

    private Reward reward;
    private boolean opened;

    /**
     * Default class constructor. Just setting _opened_ to false.
     */
    public Door() {
        opened = false;
    }

    /**
     * Setting reward behind that door.
     */
    public void setReward() {
        this.reward = new Reward();
    }

    /**
     * Check dor reward behind door.
     * @return true if there is reward.
     */
    public boolean isRewardBehind() {
        return !(reward == null);
    }

    /**
     * Opening the door.
     */
    public void open() {
        opened = true;
    }

    /**
     * Check if door is opened.
     * @return value of opened variable.
     */
    public boolean isOpened() {
        return opened;
    }

    /**
     * Resetting the door. Setting reward to null and opened to false.
     */
    public void resetDoor() {
        reward = null;
        opened = false;
    }
}
