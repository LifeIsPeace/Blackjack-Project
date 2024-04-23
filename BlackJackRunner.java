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
    private int betAmount;
    private boolean betting;
    private boolean firstHand;
    private boolean nextTurn;
    private int timer;
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
        betAmount = 0;
        table = new Table(numberOfDecks, playersPerTable, minimumCardsBeforeShuffle, minimumBet, this);
        setupButtons();
        Player player = table.getPlayer(0);
        Dealer dealer = table.getDealer();
        betting = true;
        firstHand = true;
        nextTurn = false;
        timer = -1;
        if ((player.getHandValue() + (player.getAceCount() * 11) == 21) || (player.getHandValue() + player.getAceCount() == 21)) {
            table.getWorld().showText("WIN", 630, 630);
        }
        else if((dealer.getHandValue() + (dealer.getAceCount() * 11) == 21) && !(dealer.getHandValue() + dealer.getAceCount() == 21)) {
            table.getWorld().showText("GAMEOVER", 630, 630);
        }
    }
    
    public void act(){
        table.getWorld().showText("Balence: " + startingMoney, 800, 100);
        table.getWorld().showText("Bet: " + betAmount, 800, 125);
        
        if (timer > -1 && timer < 100) {
            timer++;
        }
        else if (timer >= 100) {
            table.deleteOldCards();
            table.getPlayer(0).clearHand();
            table.getDealer().clearHand();
            timer = -1;
            nextTurn = true;
        }
        
        if (!betting && firstHand) {
            firstHand = false;
            table.dealStartingHands();
        }
        else if (nextTurn && !betting) {
            table.createNextTurnCards();
            nextTurn = false;
        }
        
        if (startingMoney == 0 && betAmount == 0) {
            timer = -2;
            table.getWorld().showText("GAME OVER", 630, 630);
        }
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
        HitButton hitButton = new HitButton(table, this);
        StandButton standButton = new StandButton(table, this);
        DoubleDownButton ddButton = new DoubleDownButton(table, this);
        TextInput textInput = new TextInput(minimumBet + "", 0, 0, this);
        
        //This should pop up when user is able to. Do later
        //SplitPairsButton spButton = new SplitPairsButton();
        
        addObject(hitButton, hitButton.getX(), hitButton.getY());
        addObject(standButton, standButton.getX(), standButton.getY());
        addObject(ddButton, ddButton.getX(), ddButton.getY());
        addObject(textInput, 800, 500);
        
    }
    
    public int getStartingMoney() {
        return startingMoney;
    }
    public void setStartingMoney(int startingMoney) {
        this.startingMoney = startingMoney;
    }
    public int getBetAmount() {
        return betAmount;
    }
    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
    public boolean isBetting() {
        return betting;
    }
    public void setBetting(boolean betting) {
        this.betting = betting;
    }
    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }
}