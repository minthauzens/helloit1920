package lv.helloit;

import java.util.LinkedList;
import java.util.Queue;

public class BowlingGame {
    Queue<Player> players = new LinkedList<>();
    private int playerCount = 0;

    public BowlingGame() {
        addPlayer();
    }

    public void addPlayer() {
        String playerName = "" + (playerCount + 1);
        this.players.add(new Player(playerName));
        playerCount++;
    }

//    public void addPlayer(String name) {
//        this.players.add(new Player(name));
//        playerCount++;
//    }

    public void roll(int pins) {
        if (getCurrentPlayer().roll(pins)) {
            changePlayer();
        }
    }

    private void changePlayer() {
        this.players.add(this.players.remove());
    }

    private Player getCurrentPlayer() {
        return players.peek();
    }

    public int getPlayerScore(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                return player.getTotalScore();
            }
        }
        return -1;
    }

    public void printScores() {
        int i = 1;
        for (Player player : this.players) {
            System.out.println(i + ". " + player);
            i++;
        }
    }

    public int getCurrentFrame() {
        return getCurrentPlayer().getFrame();
    }
}
