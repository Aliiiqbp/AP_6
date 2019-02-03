package src.Model;

public class Time {

    private int turn;

    public Time() {
        turn = 0;
    }

    public void turn() {
        turn++;
    }

    public int getDuration() {
        return turn;
    }

    public void restart() {
        turn = 0;
    }
}
