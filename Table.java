import java.util.ArrayList;
import greenfoot.*;
/**
 * This class runs the game
 * Yes I am a fool and didn't realize a world could have an act method
 * It's too late, this will run the game
 * 
 * @author Brejon T 
 * @version 3.28.24
 */
public class Table extends Actor
{
    // For now only 1 player and 1 dealer
    private ArrayList<Player> playersAtTable = new ArrayList<>();
    private Dealer dealer = new Dealer();
    private World world;
    private Shoe tableShoe;
    private int minBet;
    private int numOfDecks;
    private int minCardsForReshuffle;
    private boolean dealerBlackjack;
    private static final int spacing = 57;
    private static final int numOfPlayerCards = 1;
    private static final int MAX_VALUE = 21;
    private static final int DEALER_WILL_HIT = 17;
    private static int[] DEALER_CARD_XY = {138, 156};
    private static int[] PLAYER_CARD_XY = {289, 541};
    /**
     * Sets up the table for play
     */
    public Table(int numOfDecks, int numOfPlayers, int minCardsForReshuffle, int minBet, World world){
        this.numOfDecks = numOfDecks; 
        this.minCardsForReshuffle = minCardsForReshuffle;
        this.minBet = minBet;
        this.world = world;
        tableShoe = new Shoe(numOfDecks);
        DEALER_CARD_XY[0] = 138;
        PLAYER_CARD_XY[0] = 289;
        for(int i = 0 ; i < numOfPlayers; i ++){
            addPlayer(new Player());
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
            world.stopped();
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
        world.addObject(dealer.getCard(0), DEALER_CARD_XY[0],DEALER_CARD_XY[1]);
        DEALER_CARD_XY[0] += spacing;
        world.addObject(dealer.getCard(1), DEALER_CARD_XY[0], DEALER_CARD_XY[1]);
        
        for(Player players: playersAtTable){
            players.startingHand(tableShoe);
        }
        if(dealer.aceElevenValue() == MAX_VALUE){
            dealerBlackjack = true;
        }
        for(Player player: playersAtTable){
            world.addObject(player.getCard(0),PLAYER_CARD_XY[0], PLAYER_CARD_XY[1]);
            PLAYER_CARD_XY[0] += spacing;
            world.addObject(player.getCard(1), PLAYER_CARD_XY[0], PLAYER_CARD_XY[1]);
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
    
    // This hit Method adds card to Table, called by hitButton
    public void hit(int index) {
        PLAYER_CARD_XY[0] += spacing;
        world.addObject(getPlayer(0).getCard(index), PLAYER_CARD_XY[0], PLAYER_CARD_XY[1]);
        getPlayer(0).scaleCard(getPlayer(0).getCard(index));
    }
    
    public void hitDealer(int index) {
        DEALER_CARD_XY[0] += spacing;
        world.addObject(dealer.getCard(index), DEALER_CARD_XY[0], DEALER_CARD_XY[1]);
        dealer.scaleCard(dealer.getCard(index));
    }
    
    public void deleteOldCards() {
        for (int i = 0; i < getPlayer(0).getCardCount(); i++) {
            world.removeObject(getPlayer(0).getCard(i));
            //This is a bandaid solution because for some reason the x values are off if you reset them
            if (i != 1) {
                PLAYER_CARD_XY[0] -= spacing;
            }
        }
        for (int i = 0; i < dealer.getCardCount(); i++) {
            world.removeObject(dealer.getCard(i));
            if (i != 1) {
                DEALER_CARD_XY[0] -= spacing;
            }
        }
    }
    
    public void createNextTurnCards() {
        dealer.startingHand(tableShoe);
        world.addObject(dealer.getCard(0), DEALER_CARD_XY[0],DEALER_CARD_XY[1]);
        DEALER_CARD_XY[0] += spacing;
        world.addObject(dealer.getCard(1), DEALER_CARD_XY[0], DEALER_CARD_XY[1]);
        
        for(Player players: playersAtTable){
            players.startingHand(tableShoe);
        }
        for(Player player: playersAtTable){
            world.addObject(player.getCard(0),PLAYER_CARD_XY[0], PLAYER_CARD_XY[1]);
            PLAYER_CARD_XY[0] += spacing;
            world.addObject(player.getCard(1), PLAYER_CARD_XY[0], PLAYER_CARD_XY[1]);
        }
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
    
    public Player getPlayer(int index) {
        return playersAtTable.get(index);
    }
    public Dealer getDealer() {
        return dealer;
    }
    
    public Shoe getShoe() {
        return tableShoe;
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
    public int getAmountOfCards() {
        return getPlayer(0).getCardCount();
    }
    public int getAmountOfDealerCards() {
        return dealer.getCardCount();
    }
    public World getWorld() {
        return world;
    }
}

/*
 * The table will handle separate aces and making sure the player only hits once for
 * each ace
 * 
 * Make sure to add the betting amounts for each player. They bet before they see their hand
 * 
 */