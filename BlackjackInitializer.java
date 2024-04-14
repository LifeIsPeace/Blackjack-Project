import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RunBlackjack here.
 * 
 * @author Brejon T 
 * @version 4.11.24
 */
public class BlackjackInitializer extends Actor
{
    private static final int DEFAULT_STARTING_MONEY = 100;
    private static final int DEFAULT_PLAYERS_PER_TABLE = 1;
    private static final int DEFAULT_NUMBER_OF_DECKS = 6;
    private static final int DEFAULT_MINIMUM_CARDS_BEFORE_SHUFFFLE = 78;
    private static final int DEFAULT_MINIMUM_BET = 10;
    private int startingMoney;
    private int playersPerTable;
    private int numberOfDecks;
    private int minimumCardsBeforeShuffle;
    private int minimumBet;
    
    public BlackjackInitializer(int startingMoney, int playersPerTable, int numberOfDecks, int minimumCardsBeforeShuffle, int minimumBet){
        this.startingMoney = startingMoney;
        this.playersPerTable = playersPerTable;
        this.numberOfDecks = numberOfDecks;
        this.minimumCardsBeforeShuffle = minimumCardsBeforeShuffle;
        this.minimumBet = minimumBet;
    }
    
    /**
     * Awaits user input before calling a method that initalizes the game
     * Then constantly ensures no errors occur
     */
    public void act()
    {
    
    }
}
