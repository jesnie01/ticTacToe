import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
        Create a two player tic tac toe game
            Each player has 3 turns.
            The program does not need to find a winner
            Ask the players for their names
            Present the name with their symbol for each turn
            Present the board after each turn
            Positions are written with the index values 1,2,3 (The user does not know zero based index)
        Use 3 char arrays
            static char[] row1 = {'_','_','_'};
            static char[] row2 = {'_','_','_'};
            static char[] row3 = {'_','_','_’};
        Or use one 2D char array
            Static char[][] board = {{'_','_','_’}, {'_','_','_’}, {'_','_','_’}};

        Divide the game into small sub tasks, describe with pseudo code.
        Then implement the methods.

        Do once:
        Player 1 enter name
        Player 2 enter name
        Create game board

        Do every turn:
        Tell the player who to act
        Show Gameboard
        Ask for input
        Change array
        Show new Gameboard

         */
public class Main {
    private static int turn = 1;
    private static int column = 0;
    private static int row = 0;
    private static boolean validatedInfo = true;
    private static Scanner in = new Scanner(System.in);
    private static String player1 = "";
    private static String player2 = "";
    private static final char player1Symbol = 'x';
    private static final char player2Symbol = 'o';
    private static char[] row1 = {'-','-','-'};
    private static char[] row2 = {'-','-','-'};
    private static char[] row3 = {'-','-','-'};
    public static void main(String[] args) {

        askPlayerNames();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                showGameBoard();
                showWhoToPlay(turn);
                takePlayerInput();
                turn++;
            }
        }
        showGameBoard();
    }

    private static void changeGameboard(int columnInput, int rowInput) {
        if(turn%2==1){
            switch (rowInput){
                case 1:
                    if(row1[columnInput-1]=='-') {
                        row1[columnInput - 1] = 'x';
                        break;
                    }else{
                        System.out.println("This spot is unavailable");
                        takePlayerInput();
                        break;
                    }
                case 2:
                    if(row2[columnInput-1]=='-') {
                        row2[columnInput - 1] = 'x';
                        break;
                    }else {
                        System.out.println("This spot is unavailable");
                        takePlayerInput();
                        break;
                    }
                case 3:
                    if(row3[columnInput-1]=='-') {
                        row3[columnInput - 1] = 'x';
                        break;
                    }else {
                        System.out.println("This spot is unavailable");
                        takePlayerInput();
                        break;
                    }
                default:
                    System.out.println("Please enter values between 1-3");
            }
        }else {
            switch (rowInput){
                case 1:
                    if(row1[columnInput-1]=='-') {
                        row1[columnInput - 1] = 'o';
                        break;
                    }else {
                        System.out.println("This spot is unavailable");
                        takePlayerInput();
                        break;
                    }
                case 2:
                    if(row2[columnInput-1]=='-') {
                        row2[columnInput - 1] = 'o';
                        break;
                    }else {
                        System.out.println("This spot is unavailable");
                        takePlayerInput();
                        break;
                    }
                case 3:
                    if(row3[columnInput-1]=='-') {
                        row3[columnInput - 1] = 'o';
                        break;
                    }else {
                        System.out.println("This spot is unavailable");
                        takePlayerInput();
                        break;
                    }
                default:
                    System.out.println("Please enter values between 1-3");
            }

        }
    }

    private static void takePlayerInput() {
            System.out.println("Enter column: ");
            column = in.nextInt();
            System.out.println("Enter row: ");
            row = in.nextInt();
            changeGameboard(column, row);
    }

    private static void showWhoToPlay(int a) {
        if(a%2==1){
            System.out.printf("%s's turn to play: %n",player1);
        }else{
            System.out.printf("%s's turn to play: %n",player2);
        }

    }

    private static void askPlayerNames() {
        System.out.println("Enter player 1's name: (x) ");
        player1 = in.nextLine();
        System.out.println("Enter players 2's name: (o) ");
        player2 = in.nextLine();
    }

    private static void showGameBoard() {
        System.out.println("Gameboard:");
        System.out.println(row1);
        System.out.println(row2);
        System.out.println(row3);
    }
}