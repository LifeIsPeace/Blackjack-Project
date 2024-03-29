import java.util.ArrayList;
/**
 * Write a description of class Deck here.
 * 
 * @author Brejon T
 * @version (a version number or a date)
 */
public class Deck  
{
    private ArrayList<Card> deck = new ArrayList<>();
    
    public Deck(){
        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Rank rank: Card.Rank.values()){
                deck.add(new Card(rank, suit));
            }
        }
        //System.out.println(deck.size());
    }
    
    public Card deal(){
        Card card = deck.get(deck.size() - 1);
        deck.remove(card);
        return card;
    }
    
    public int size(){return deck.size();}
}
