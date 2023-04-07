import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players (2-4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players[i] = new Player();
        }
        
        System.out.print("Do you want to enable action cards? (y/n): ");
        String enableActionCards = scanner.nextLine();
        
        Game game = new Game(players, enableActionCards.equalsIgnoreCase("y"));
        Player winner = game.playGame();
        
        System.out.println("The winner is: " + winner.getName());
    }
}
