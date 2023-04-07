public class Card {
    private Suit suit;
    private Rank rank;
    
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public boolean matches(Card card) {
        return this.suit == card.suit || this.rank == card.rank;
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
