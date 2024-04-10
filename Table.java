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
    private boolean dealerBlackjack;
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
        dealer.clearHand();
        dealerBlackjack = false;
    }
    
    private void dealStartingHands(){
        dealer.startingHand(tableShoe);
        for(Player players: playersAtTable){
            players.startingHand(tableShoe);
        }
        if(dealer.aceElevenValue() == MAX_VALUE){
            dealerBlackjack = true;
        }
    }
    
    private void dealerTurn(){
        while((dealer.isSoft() && dealer.aceElevenValue() == DEALER_WILL_HIT) || 
        dealer.aceElevenValue() < DEALER_WILL_HIT){
            dealer.addCard(dealCard());
        }
    }
    
    public Card dealCard(){
        if(tableShoe.cardsRemaining() == 0){
            tableShoe = new Shoe(numOfDecks);
            tableShoe.shuffle();
        }
        return tableShoe.dealCard();
    }
    
    public void addPlayer(Player player){
        playersAtTable.add(player);
    }
    
    public void removePlayer(Player player){
        playersAtTable.remove(player);
    }
    
    public int numPlayers(){
        return playersAtTable.size();
    }
    
    public double minimumBet(){
        return minBet;
    }
    
    public boolean dealerHasBlackjack(){
        return dealerBlackjack;
    }
    
    public Card dealerShownCard(){
        return dealer.getCard(0);
    }
    
    public RuleHand dealer(){
        return dealer.getRuleHand();
    }
    
}

/*
 * The table will handle separate aces and making sure the player only hits once for
 * each ace
 * 
 * Make sure to add the betting amounts for each player. They bet before they see their hand
 * 
 */