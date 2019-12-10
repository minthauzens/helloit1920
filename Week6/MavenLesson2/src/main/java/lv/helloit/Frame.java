package lv.helloit;

public class Frame {
    private int maxRolls;
    private int roll;

    public Frame(int maxRolls) {
        this.maxRolls = maxRolls;
        this.roll = 1;
    }

    public boolean checkSpare(int pins) {

        return false;
    }

    public boolean checkStrike(int pinsDroppedThisThrow) {
        if (this.maxRolls == 2) {
            if(this.roll == 1 && pinsDroppedThisThrow == 10){
                return true;
            } else {
                return false;
            }
        } else if (this.maxRolls == 3) {
        }
        return false;
    }
}
