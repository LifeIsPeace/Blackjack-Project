import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will run all apsects of the blackjack game
 * 
 * @author Brejon Turner 
 * @version 4.13.24
 */
public class BlackJackRunner extends World
{

    /**
     * Will initialize and run the blackjack game
     * 
     */
    public BlackJackRunner()
    {    
        // 1920 by 1080 is too big
        super(1260, 710, 1); 
        Button example = new Button("Hey lol", 250, 200);
        addObject(example, example.getX(), example.getY());
        
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
* Used in BlackJackRunner Constructor
* Test for clicking a button. Works for the first two constructors of Button.
* Third hasn't been tested
* 
* StartButton startButton = new StartButton("Testing", 500, 500);
* addObject(startButton, startButton.getX(), startButton.getY());
* System.out.println(startButton.getX());
* 
*/
