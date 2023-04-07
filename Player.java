import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void addCardToHand(Card card) {
        hand.add(card);
    }
    
    public Card playCard(int index) {
        return hand.remove(index);
    }
    
    public int getHandSize() {
        return hand.size();
    }
    
    public List<Card> getHand() {
        return hand;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
