package lv.helloit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    private static ByteArrayOutputStream outContent;
    private BowlingGame game;

    @BeforeEach
    void setup() {
        game = new BowlingGame();
    }

    @BeforeAll
    static void beforeAll() {
        outContent = new ByteArrayOutputStream();
//        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//        PrintStream originalErr = System.err;
//        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void afterAll() {
        System.setOut(null);
//        System.setErr(null);
    }

    @Test
    void whenRollOneThenTwoScoreShouldBeThree() {
        makeTurn(1, 2);
        assertEquals(3, game.getPlayerScore("1"));
    }

    @Test
    void afterSpareFirstRollScoreShouldBeDoubled() {
        makeTurn(5, 5);
        game.roll(2);
        assertEquals(14, game.getPlayerScore("1"));
    }

    @Test
    void shouldNotDoubleFourthThrowsScoreAfterSpare() {
        makeTurn(5, 5);
        makeTurn(2, 4);

        assertEquals(18, game.getPlayerScore("1"));
    }

    @Test
    void shouldCount2ConsecutiveSpares() {
        makeTurn(5, 5);
        makeTurn(5, 5);
        game.roll(5);
        assertEquals(35, game.getPlayerScore("1"));
    }

    @Test
    void afterStrikeNextTwoScoresShouldBeDoubled() {
        makeStrike();
        makeTurn(5, 2);
        assertEquals(24, game.getPlayerScore("1"));
    }

    @Test
    void twoConsecutiveStrikesShouldIncreaseThrowOfTheThirdThrow3Times() {
        makeStrike();
        makeStrike();
        game.roll(5);
        assertEquals(45, game.getPlayerScore("1"));
    }

    @Test
    void strikeShouldNotAffectThirdThrowAfterIt() {
        makeStrike();
        makeTurn(1, 1);
        game.roll(5);
        assertEquals(19, game.getPlayerScore("1"));
    }

    @Test
    void StrikeShouldIncreaseTheScoreOfNextSpare() {
        makeStrike();
        makeTurn(0, 10);
        makeTurn(5, 4);
        assertEquals(44, game.getPlayerScore("1"));
    }

    @Test
    void simpleTwoPlayerGame() {
        game.addPlayer();
        makeTurn(4, 5);
        makeTurn(2, 3);

        assertEquals(9, game.getPlayerScore("1"));
        assertEquals(5, game.getPlayerScore("2"));
    }

    @Test
    void returnScoreOfNotExistingPlayer() {
        assertEquals(-1, game.getPlayerScore("2"));
    }

    @Test
    void multilayerScoreShouldPrintEachHPlayerScores() {
        game.addPlayer();
        makeTurn(5,0);
        makeTurn(5,0);

//        String scores = "1. 1: 5." + "\n" + "2. 2: 5."+ "\n";
        String scores = "1. 1: 5." + "\r\n" + "2. 2: 5."+ "\r\n";
        game.printScores();
        assertEquals(scores, outContent.toString());
    }

    @Test
    void atTheStartFrameNumberShouldBeOne(){
        assertEquals(1, game.getCurrentFrame());
    }

    @Test
    void atTheSecondTurnFrameShouldBeTwo() {
        game.addPlayer();
        makeTurn(4,3);
        makeTurn(4,3);
        makeTurn(4,3);
        assertEquals(2, game.getCurrentFrame());
    }
    @Test
    void TenthFrameShouldHaveThreeThrows() {
        for (int i = 0; i < 9; i++) {
            makeTurn(1,1);
        }
        assertEquals(10, game.getCurrentFrame());

        game.roll(10);
        game.roll(10);
        assertEquals(10, game.getCurrentFrame());
        game.roll(10);
        assertEquals(11, game.getCurrentFrame());
        game.roll(10);
        assertEquals(12, game.getCurrentFrame());
        game.roll(10);
        assertEquals(13, game.getCurrentFrame());


    }

    void makeTurn(int roll1, int roll2) {
        game.roll(roll1);
        game.roll(roll2);
    }

    void makeStrike() {
        game.roll(10);
    }
}