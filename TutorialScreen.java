import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialScreen here.
 * 
 * @author Brejon T 
 * @version 4.16.24
 */
public class TutorialScreen extends World
{

    /**
     * Constructor for objects of class TutorialScreen.
     * 
     */
    public TutorialScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1260, 710, 1);
        
        GreenfootImage background = new GreenfootImage("images//background_images//bg_image.png");
        background.scale(1260, 710);
        this.setBackground(background);
        
        StartButton startButton = new StartButton(630, 200);
        addObject(startButton, startButton.getX(), startButton.getY());
        showText("In blackjack, the goal is to beat the dealer.\n Your objective is to get as close to 21 with your cards without going over. \n" + 
        "You win if the value of your hand is higher than the dealer's without exceeding 21.\n The Dealer wins if they go over your amount without exceeding 21.", 630, 400);

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
/*
 * Or, just instantiate the world class which you want to be the first world interactively,
 * by right-clicking the class and calling the constructor. No need to go editing text files :)
 * Just initiate the title screen as the starting world.
 */
