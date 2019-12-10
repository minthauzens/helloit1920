package lv.helloit;

public class Player {
    private String name;
    private Modifier modifier;
    private int frame;
    private int totalScore;
    private int pinsDroppedAtThisTurn;
    private boolean isFirstThrow;
    private int frameTenRoll;

    public Player(String name) {
        this.name = name;
        this.totalScore = 0;
        this.frame = 1;
        this.pinsDroppedAtThisTurn = 0;
        this.isFirstThrow = true;
        this.modifier = new Modifier();
        this.frameTenRoll = 0;
    }

    public boolean roll(int pins) {
        pinsDroppedAtThisTurn += pins;
        totalScore += pins * modifier.getModifier();
        if (frame == 10) {
            frameTenRoll++;
            if (frameTenRoll < 3) {
                if (pinsDroppedAtThisTurn % 10 == 0) {
                    modifier.strike();
                }
                if (pinsDroppedAtThisTurn % 10 != 0 && frameTenRoll == 2) {
                    return endGame();
                }
                return false;
            } else {
                return endGame();
            }
            // ja otrais metiens ir bijis spare tad score nemainais tikai mainās vizuālais attēlojums

        } else {
            if (checkStrike()) {
                return endTurn();
            } else {
                checkSpare();
                if (!isFirstThrow) {
                    return endTurn();
                } else {
                    isFirstThrow = false;
                    return false;
                }
            }
        }
    }

    private boolean endGame() {
        return endTurn();
    }

    public boolean endTurn() {
        isFirstThrow = true;
        pinsDroppedAtThisTurn = 0;
        frame++;
        return true;

    }

    public void checkSpare() {
        if (!isFirstThrow && pinsDroppedAtThisTurn == 10) {
            modifier.spare();
        }
    }

    public boolean checkStrike() {
        if (isFirstThrow && pinsDroppedAtThisTurn == 10) {
            modifier.strike();
            return true;
        }
        return false;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public String getName() {
        return this.name;
    }

    public int getFrame() {
        return frame;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.totalScore + ".";
    }
}