
public class Peterson {
    private volatile boolean[] flag = new boolean[2];
    private volatile int turn = 0;

    public void lock(int id) {
        int other = 1 - id;
        flag[id] = true;
        turn = other;
        while (flag[other] && turn == other);
    }

    public void unlock(int id) {
        flag[id] = false;
    }
}



