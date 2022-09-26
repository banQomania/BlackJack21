package BlackJackAssessment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    Hand firsthand;
    @BeforeEach
    void setUp() {
        firsthand = new Hand();
        firsthand.addCard(new Card(Suit.SPADES,Rank.ACE));
        firsthand.addCard(new Card(Suit.DIAMONDS,Rank.ACE));
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getCorrectHandCardCount() {
        assertEquals(2, firsthand.getHandCardCount(), "Length of firsthand is 2");
    }

    @Test
    void getWrongHandCardCount() {
        assertNotEquals(3, firsthand.getHandCardCount(), "Length of firsthand is 3");
    }
}