import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Achievements here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Achievements extends World
{
    /**
     * Constructor for objects of class Achievements.
     * 
     */
    public static GreenfootImage AchievementsMenu;
    public Achievements(BlackJackRunner bjr)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1260, 710, 1);
        GreenfootImage AchievementsMenu = new GreenfootImage("images//background_images//BG.png");
        AchievementsMenu.scale(1260, 710);
        this.setBackground(AchievementsMenu);

        BackButton backButton = new BackButton(bjr);
        addObject(backButton,120,80);

        BrokeButton brokeButton = new BrokeButton();
        addObject(brokeButton,250,190);

        DrinkingageButton drinkingageButton = new DrinkingageButton();
        addObject(drinkingageButton,1100,200);

        DrumsButton drumsButton = new DrumsButton();
        addObject(drumsButton,710,460);

        ThousandButton thousandButton = new ThousandButton();
        addObject(thousandButton,250,440);

        TwinsButton twinsButton = new TwinsButton();
        addObject(twinsButton,1100,460);

        YikesButton yikesButton = new YikesButton();
        addObject(yikesButton,710,190);

        showText("BROKER THAN BROKE:\n You have now run out of money to bet,\n place your items on the table, \n and continue losing it all!", 230,300); 
        showText("DRINKING AGE:\n Congratulations!\n You went over 21 \n more than 5 times!", 1100, 300); 
        showText("WE'RE SCARED FOR YOU:\n You have lost $500 this game \n , and it's getting a little concerning.", 710, 300);
        showText("TWINS:\n Congratulations\n You hit twice in \n the same game!", 1110, 570); 
        showText("QUEUE THE DRUMS:\n YOU HAVE WON $1000 \n PLAYING BLACKJACK!", 710,570); 
        showText("FOR CENTURIES:\n It might be time to take a break.\n You have spent 100 hours playing blackjack!\n Let's touch some grass,\n take a shower, and enjoy life.\n Come back when you're stable.",250, 570); 

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

}
