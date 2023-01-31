public class BowlingGame {
    int[] parties;
    int partieActuel;

    public BowlingGame() {
        this.parties = new int[30];
    }

    public void roll(int p) {
        parties[partieActuel++] = p;
    }

    public int score() {
        int score = 0;
        int frame = 0;

        return score;
    }


    private int sumOfRolls(int frame) {
        return parties[frame] + parties[frame + 1];
    }
}