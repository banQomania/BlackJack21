package BlackJackAssessment;
/*
This class is the base class of the Player in a BlackJack 21 game.
@Author Blessing Sibanda
 */

public class Player {
    private final String name;
    private final Hand hand;
    private int score;


    public boolean hasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    private boolean hasWon;

    public void setScore(int score) {
        this.score = score;
    }

    public Player(String name,Hand hand) {
        this.hand = hand;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore(){
        return score;
    }

    public int getHandSize(){
        return hand.getHandCardCount();
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Player: "+name+", Hand : " + hand.toString()+" Score: "+score;
    }
}
