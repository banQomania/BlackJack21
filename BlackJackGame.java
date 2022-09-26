package BlackJackAssessment;

import java.util.List;

/*
This class represents the game's main mechanics to play a single round between dealer and player
@author Blessing Sibanda
 */
public class BlackJackGame {

    public  Player playRound(Player dealer, Player player){
        var playerScore = getHandScore(player.getHand());
        player.setScore(playerScore);
        var dealerScore = getHandScore(dealer.getHand());
        dealer.setScore(dealerScore);

        if((playerScore>=dealerScore && playerScore<=21) ||
                (player.getHandSize()==5 && playerScore<=21)) {
            player.setHasWon(true);
            System.out.println(player + " ,Result: WIN ");
        }else{
            player.setHasWon(false);
            System.out.println(player +" ,Result: LOSE");
        }
        System.out.println(dealer);
        return player.hasWon() ? player : dealer;
    }
    public int getScoreWithoutAces(Hand hand){
        return hand.getCards().stream()
                .filter(card -> card.getRank()!=Rank.ACE)
                .mapToInt(card -> card.getRank().getValue()).sum();
    }
    public int getHandScore(Hand hand){
        var score = getScoreWithoutAces(hand);
        var numOfAces = checkNumberOfAces(hand.getCards());
        if(numOfAces>=1)
            for(int i = 0; i < numOfAces; i++) {
                score = 11+score < 22 ? 11+score : 1+score;
            }
        return score;
    }

    public int checkNumberOfAces(List<Card> cards){
        return (int) cards.stream()
                .filter(card -> card.getRank().equals(Rank.ACE)).count();
    }

    public static void main(String ... args){

    }
}
