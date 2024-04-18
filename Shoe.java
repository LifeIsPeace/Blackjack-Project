import java.util.Collections;
import java.util.ArrayList;
/**
 * Write a description of class Shoe here.
 * 
 * @author Brejon T 
 * @version 4.17.24
 */
public class Shoe  
{
    private ArrayList<Card> shoe = new ArrayList<>();
    
    public Shoe(int numOfDecks){
        for(int i = 0; i < numOfDecks; i++){
            addDeck(new Deck()); // adds cards
        }
        shuffle(); //Always a random deck of cards
    }
    
    public Card dealCard(){
        Card card = shoe.get(shoe.size() - 1);
        shoe.remove(card);
        return card;
    }
    
     private void addDeck(Deck deck){
        while(deck.size() > 0){
            shoe.add(deck.deal());
        }
    }
    
    public int cardsRemaining(){
        return shoe.size();
    }
    
    public void listOfCards(){
        for(int i = 0; i < shoe.size(); i++){
            System.out.println(shoe.get(i));
        }
    }
    
    public void shuffle(){Collections.shuffle(shoe);}
}
