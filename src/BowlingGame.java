
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

        for (int i = 0; i < 10; i++) {
            if (isStrike(frame)) {
                score += 10 + strikeBonus(frame);
                frame++;
            } else if (isSpare(frame)) {
                score += 10 + spareBonus(frame);
                frame += 2;
            } else {
                score += sumOfRolls(frame);
                frame += 2;
            }
        }

        return score <0? 0:score;
    }

    private boolean isStrike(int frame) {
        return parties[frame] == 10;
    }

    private boolean isSpare(int frame) {
        return sumOfRolls(frame) == 10;
    }

    private int strikeBonus(int frame) {
        return sumOfRolls(frame+1);
    }

    private int spareBonus(int frame) {
        return parties[frame+2];
    }

    private int sumOfRolls(int frame) {
        return parties[frame] + parties[frame+1];
    }
}