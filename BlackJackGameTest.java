package BlackJackAssessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackGameTest {

    Player dealer;
    BlackJackGame game;
    @BeforeEach
    void setUp() {
        game = new BlackJackGame();
        List<Card> dealerCards = List.of(
                new Card(Suit.SPADES,Rank.JACK),
                new Card(Suit.HEARTS,Rank.NINE));
        dealer = new Player("Dealer",new Hand(dealerCards));
    }

    @Test
    void playerWinHasFiveCards() {
        List<Card> billysCards = List.of(
                new Card(Suit.SPADES,Rank.TWO),
                new Card(Suit.DIAMONDS,Rank.TWO),
                new Card(Suit.HEARTS,Rank.TWO),
                new Card(Suit.DIAMONDS,Rank.FOUR),
                new Card(Suit.CLUBS,Rank.FIVE));
        Player billy = new Player("Billy",new Hand(billysCards));
        assertEquals(billy, game.playRound(dealer,billy),"Dealer is the winner of this around against Billy");
    }

    @Test
    void playerWinTwoAces() {
        List<Card> lemmyCards = List.of(
                new Card(Suit.SPADES,Rank.ACE),
                new Card(Suit.DIAMONDS,Rank.ACE),
                new Card(Suit.HEARTS,Rank.SEVEN));
        Player lemmy = new Player("Lemmy", new Hand(lemmyCards));
        assertEquals(lemmy, game.playRound(dealer,lemmy),"Lemmy is the winner of this around against the dealer");
    }

    @Test
    void testScoreEqualTo(){
        List<Card> cards = List.of(
                new Card(Suit.SPADES,Rank.ACE),
                new Card(Suit.DIAMONDS,Rank.ACE),
                new Card(Suit.HEARTS,Rank.SEVEN));
        assertEquals(19,game.getHandScore(new Hand(cards)),"Hand is equal to 19");
    }

    @Test
    void dealerWinScoreGreater(){
        List<Card> cards = List.of(
                new Card(Suit.DIAMONDS,Rank.QUEEN),
                new Card(Suit.SPADES,Rank.SIX),
                new Card(Suit.DIAMONDS,Rank.NINE));
        Player carla  = new Player("Carla",new Hand(cards));
        assertEquals(dealer,game.playRound(dealer,carla),"Carla loses this round against the dealer");
    }

    @Test
    void dealerWin(){
        List<Card> cards = List.of(
                new Card(Suit.DIAMONDS,Rank.KING),
                new Card(Suit.SPADES,Rank.FOUR),
                new Card(Suit.CLUBS,Rank.FOUR));
        Player andrew = new Player("Andrew",new Hand(cards));
        assertEquals(dealer, game.playRound(dealer,andrew), "Dealer wins this round against Andrew");
    }

    @Test
    void checkNumberOfAces(){
        List<Card> cards = List.of(
                new Card(Suit.DIAMONDS,Rank.ACE),
                new Card(Suit.SPADES,Rank.ACE),
                new Card(Suit.HEARTS,Rank.ACE),
                new Card(Suit.CLUBS,Rank.ACE));
       assertEquals(4,game.checkNumberOfAces(cards), "Should return the count of 4 Aces");
    }

    @Test
    void getHandScoreWithAces(){
        List<Card> cards = List.of(
                new Card(Suit.DIAMONDS,Rank.ACE),
                new Card(Suit.SPADES,Rank.ACE),
                new Card(Suit.HEARTS,Rank.ACE),
                new Card(Suit.CLUBS,Rank.ACE));
        assertEquals(0,game.getScoreWithoutAces(new Hand(cards)), "Should return the score of 0");
    }

    @Test
    void getHandScoreWithoutAces(){
        List<Card> cards = List.of(
                new Card(Suit.DIAMONDS,Rank.QUEEN),
                new Card(Suit.SPADES,Rank.THREE),
                new Card(Suit.HEARTS,Rank.NINE),
                new Card(Suit.CLUBS,Rank.FIVE),
                new Card(Suit.CLUBS,Rank.TWO));
        assertEquals(29,game.getScoreWithoutAces(new Hand(cards)), "Should return the score of 29");
    }

    @Test
    void checkNullScoreWithoutAces(){
        assertEquals(0,game.getScoreWithoutAces(new Hand()));
    }

    @Test
    void checkNullNumberAces(){
        List<Card> cards = new ArrayList<>();
        assertEquals(0,game.checkNumberOfAces(cards));
    }

    @Test
    void getHandScoreNull(){
        assertEquals(0, game.getHandScore(new Hand()));
    }



}