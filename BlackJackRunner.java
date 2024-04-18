import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used for inital setup and the display of graphics (Like cards, buttons, etc...)
 * 
 * @author Brejon Turner 
 * @version 4.16.24
 */
public class BlackJackRunner extends World
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
    private Table table; // Table is technically not in world
    
    public BlackJackRunner(int startingMoney, int playersPerTable, int numberOfDecks, int minimumCardsBeforeShuffle, int minimumBet)
    {    
        // 1920 by 1080 is too big
        super(1260, 710, 1);
        GreenfootImage background = new GreenfootImage("images//background_images//bg_image.png");
        background.scale(1260, 710);
        this.setBackground(background);
        
        this.startingMoney = startingMoney;
        this.playersPerTable = playersPerTable;
        this.numberOfDecks = numberOfDecks;
        this.minimumCardsBeforeShuffle = minimumCardsBeforeShuffle;
        this.minimumBet = minimumBet;
        table = new Table(numberOfDecks, playersPerTable, minimumCardsBeforeShuffle, minimumBet, this);
        setupButtons();
        
        
        
    }
    
    public void act(){
        
    }
    
    /**
     * This method @Overrides the addObject method in the World class
     * This method will call the setLocation method from the Actor object (Necessary for the Button class)
     * @param object  An Actor object
     * @param x  An integer that represents the Actor's x coordinate
     * @param y  An integer that represents the Actor's y coordinate
     */
    @Override
    public void addObject(Actor object, int x, int y){
        super.addObject(object, x, y);
        object.setLocation(x, y);
    }
    
    private void setupButtons(){
        HitButton hitButton = new HitButton();
        StandButton standButton = new StandButton();
        DoubleDownButton ddButton = new DoubleDownButton();
        
        
        //This should pop up when user is able to. Do later
        //SplitPairsButton spButton = new SplitPairsButton();
        
        addObject(hitButton, hitButton.getX(), hitButton.getY());
        addObject(standButton, standButton.getX(), standButton.getY());
        //addObject(spButton, spButton.getX(), spButton.getY());
        addObject(ddButton, ddButton.getX(), ddButton.getY());
        
    }
    
    
}