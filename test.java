import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CardGameTest {

    private CardGame game;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;

    @Before
    public void setUp() {
        game = new CardGame();
        p1 = new Player("A");
        p2 = new Player("B");
        p3 = new Player("C");
        p4 = new Player("D");
    }

    @Test
    public void testDeal() {
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.deal();
        assertEquals(5, p1.getHand().size());
        assertEquals(5, p2.getHand().size());
    }

    @Test
    public void testPlayCardMatch() {
        game.addPlayer(p1);
        game.addPlayer(p2);
        p1.addCard(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN));
        game.playCard(p1, new Card(Card.Suit.HEARTS, Card.Rank.SEVEN));
        assertEquals(0, p1.getHand().size());
        assertEquals(1, game.getDiscardPile().size());
    }

    @Test
    public void testPlayCardNoMatch() {
        game.addPlayer(p1);
        game.addPlayer(p2);
        p1.addCard(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN));
        game.playCard(p1, new Card(Card.Suit.SPADES, Card.Rank.EIGHT));
        assertEquals(1, p1.getHand().size());
        assertEquals(0, game.getDiscardPile().size());
    }

    @Test
    public void testDrawCard() {
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.drawCard(p1);
        assertEquals(1, p1.getHand().size());
    }

    @Test
    public void testGameOver() {
        game.addPlayer(p1);
        assertTrue(game.gameOver());
        game.addPlayer(p2);
        assertFalse(game.gameOver());
        p1.addCard(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN));
        assertTrue(game.gameOver());
    }

    @Test
    public void testActionCards() {
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);
        game.addPlayer(p4);
        p1.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.KING));
        game.playCard(p1, new Card(Card.Suit.DIAMONDS, Card.Rank.KING));
        assertEquals(p3, game.getNextPlayer());
        p3.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        game.playCard(p3, new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        assertEquals(p4, game.getNextPlayer());
        p4.addCard(new Card(Card.Suit.CLUBS, Card.Rank.QUEEN));
        game.playCard(p4, new Card(Card.Suit.CLUBS, Card.Rank.QUEEN));
        assertEquals(2, p2.getHand().size());
        p2.addCard(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        game.playCard(p2, new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        assertEquals(2, p4.getHand().size());
    }
}
