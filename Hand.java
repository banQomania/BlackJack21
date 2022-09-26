package BlackJackAssessment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
The Hand class contains the cards that a player has .
The important variables are the card's list which holds cards and hasAce variable to check if the player has an ACE in their firshand for ease of firshand total sum calculation
@author Blessing Sibanda
 */

public class Hand {

    private List<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public Hand(List<Card> cards){
        this.cards = cards;
    }
    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public int getHandCardCount(){
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.stream().map(Card::toString).collect(Collectors.joining());
    }
}
