import java.util.ArrayList;
import greenfoot.*;
/**
 * The rules of the table such as busting (pause), blackjack, payout, etc...
 * Tomorrow add Player variables and finish up
 * 
 * @author Brejon T 
 * @version 3.28.24
 */
public class Table extends Actor
{
    // For now only 1 player and 1 dealer
    private ArrayList<Player> playersAtTable = new ArrayList<>();
    private Dealer dealer;
    private Shoe tableShoe;
    private int minBet;
    private int numOfDecks;
    private int minCardsForReshuffle;
    private boolean dealerBlackJack;
    private static final int MAX_VALUE = 21;
    private static final int DEALER_WILL_HIT = 17;
    
    public Table(int numOfDecks, int minCardsForReshuffle, int minBet){
        this.numOfDecks = numOfDecks; 
        this.minCardsForReshuffle = minCardsForReshuffle;
        this.minBet = minBet;
    }
    
    private void setup(){
        if(tableShoe.cardsRemaining() <= minCardsForReshuffle){
            tableShoe = new Shoe(numOfDecks);
            tableShoe.shuffle();
        }
        
        dealerBlackJack = false;
    }
}

/*
 * The table will handle separate aces and making sure the player only hits once for
 * each ace
 * 
 */