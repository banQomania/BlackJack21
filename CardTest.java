package BlackJackAssessment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Card card;
    @BeforeEach
    void setUp() {
       card  = new Card(Suit.DIAMONDS,Rank.ACE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSuit() {
        assertEquals(Suit.DIAMONDS,card.getSuit());

    }

    @Test
    void getRank() {
        assertEquals(11,card.getRank().getValue());
    }

}