import java.util.Scanner;

public class Game {
    private Player[] players;
    private Deck deck;
    private Card topCard;
    private boolean enableActionCards;
    private boolean reverseOrder;
    private boolean skipNextPlayer;
    private int currentPlayerIndex;
    private int direction;
    private int cardsToAdd;
    
    public Game(Player[] players, boolean enableActionCards) {
        this.players = players;
        this.enableActionCards = enableActionCards;
        deck = new Deck();
        deck.shuffle();
        topCard = deck.drawCard();
        direction = 1;
    }
    
    public Player playGame() {
        System.out.println("Starting game with " + players.length + " players.");
        
        dealCards();
        
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");
            System.out.println("The top card is: " + topCard);
            System.out.println("Your hand is: " + currentPlayer.getHand());
            
            if (enableActionCards) {
                if (skipNextPlayer) {
                    System.out.println("Skipping next player.");
                    skipNextPlayer = false;
                    currentPlayerIndex += 2 * direction;
                } else if (cardsToAdd > 0) {
                    System.out.println("Drawing " + cardsToAdd + " cards.");
                    for (int i = 0; i < cardsToAdd; i++) {
                        Card card = deck.drawCard();
                        if (card != null) {
                            currentPlayer.addCardToHand(card);
                        } else {
