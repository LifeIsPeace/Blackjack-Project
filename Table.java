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
    private Dealer dealer = new Dealer();
    private Shoe tableShoe;
    private int minBet;
    private int numOfDecks;
    private int minCardsForReshuffle;
    private boolean dealerBlackjack;
    private static final int MAX_VALUE = 21;
    private static final int DEALER_WILL_HIT = 17;
    
    /**
     * Sets up the table for play
     */
    public Table(int numOfDecks, int numOfPlayers, int minCardsForReshuffle, int minBet){
        this.numOfDecks = numOfDecks; 
        this.minCardsForReshuffle = minCardsForReshuffle;
        this.minBet = minBet;
        tableShoe = new Shoe(numOfDecks);
        dealer.startingHand(tableShoe);
        for(int i = 0; i < numOfPlayers; i++){
            playersAtTable.add(new Player());
            playersAtTable.get(i).startingHand(tableShoe);
        }
        setup();
    }
    
    public void act(){
        /*
         * Cards are deleted when dealt
         * Pray this works if not it's probably this that's breaking the game
         */
        if(tableShoe.cardsRemaining() < this.getMinNumOfCardsForReshuffle()){
            tableShoe = new Shoe(4);
        }
        
        /*
         * If the player quits the game will end
         */
        if(playersAtTable.size() < 1){
            System.err.print("Minimum Players Required: 1");
            this.getWorld().stopped();
        }
        
        //Continue with conditions later
    }
    
    public void setup(){
        if(tableShoe.cardsRemaining() <= minCardsForReshuffle){
            tableShoe = new Shoe(numOfDecks);
            tableShoe.shuffle();
        }
        for(Player players: playersAtTable){
            players.reset();
        }
        dealer.clearHand();
        dealerBlackjack = false;
    }
    
    public void dealStartingHands(){
        dealer.startingHand(tableShoe);
        for(Player players: playersAtTable){
            players.startingHand(tableShoe);
        }
        if(dealer.aceElevenValue() == MAX_VALUE){
            dealerBlackjack = true;
        }
    }
    
    public void dealerTurn(){
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
    
    /**
     * Used for the act method within the class
     * @return MinCardsForReshuffle
     */
    private int getMinNumOfCardsForReshuffle(){
        return minCardsForReshuffle;
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