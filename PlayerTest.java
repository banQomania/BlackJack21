package BlackJackAssessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        Hand h = new Hand();
         player = new Player( "Blessing", h);
         player.setScore(10);

    }

    @Test
    void getNameCorrect() {
        assertEquals("Blessing","Blessing");
    }

    @Test
    void getNameIncorrect() {
        assertNotEquals("Monday","Blessing");
    }

    @Test
    void getCorrectScore() {
        assertEquals(10,player.getScore());
    }

    @Test
    void getIncorrectScore() {
        assertNotEquals(1,player.getScore());
    }

    @Test
    void getCorrectHandSize() {
        assertEquals(0 ,player.getHandSize());
    }

    @Test
    void getIncorrectHandSize() {
        assertNotEquals(3 ,player.getHandSize());
    }

    @Test
    void playerHasNotWon(){
        assertFalse(player.hasWon());
    }
}