package Ch08_Classes_and_Objects;

import java.util.Scanner;

/**
 * Tic-Tac-Toe. Create a class TicTacToe that will enable you to write
 * a program to play Tic-Tac-Toe. The class containing a private 3-by-3
 * two-dimensional array. Use an enumeration to represent the value in 
 * each cell of the array. The enumeration's constants should be named
 * X, O, EMPTY (for a position that does not contain an X or an O).
 * The constructor should initialize the board elements to EMPTY. 
 * Allow two human players. Wherever the first player moves, place an 
 * X in the specified square, and place an O wherever the second player
 * moves. Each move must be to an empty square. After each move, 
 * determine whether the game has been won and whether it's a draw.
 * If you feel ambitious, modify your program so that the computer 
 * makes the moves for one of the players. Also, allow the player to
 * specify whether he or she wants to go first or second. If you feel
 * exceptionally ambitious, develop a program that will play three-
 * dimensional Tic-Tac-Toe on a 4-by-4-by-4 board [Note: This is an
 * extremely challenging project!]. @author David
 */

enum Cell { X, O, EMPTY; }
enum Status { IN_PROGRESS, WITH_RESULT, NO_RESULT; }

class TicTacToe {
    // NOTE: I could simplify using single-dimensional array but,
    // it's a requirement in this exercise to utilize 2D-array.
    private final Cell[][] square; 
    private int player, choice;
    private Cell mark;
    private char[] s;    

    public TicTacToe() {
        final int ROW = 3;
        final int COL = 3;
        square = new Cell[ROW][COL];
        for (int row = 0; row < square.length; row++) {            
            for (int col = 0; col < square[row].length; col++) {
                square[row][col] = Cell.EMPTY;
            }
        }
        s = new char[] {'0','1','2','3','4','5','6','7','8','9'};
    }

    public void play() {
        Status status = Status.IN_PROGRESS;
        do {    
            displayBoard();
            player = (player % 2) == 1 ? 1 : 2;
            mark = (player == 1) ? Cell.X : Cell.O;
            Scanner input = new Scanner(System.in);
            System.out.printf("\nPlayer %d, enter a number: ", player);
            choice = input.nextInt();
                                   
                 if (choice == 1 && square[0][0] == Cell.EMPTY) { square[0][0] = mark; }
            else if (choice == 2 && square[0][1] == Cell.EMPTY) { square[0][1] = mark; }
            else if (choice == 3 && square[0][2] == Cell.EMPTY) { square[0][2] = mark; }
            else if (choice == 4 && square[1][0] == Cell.EMPTY) { square[1][0] = mark; }
            else if (choice == 5 && square[1][1] == Cell.EMPTY) { square[1][1] = mark; }
            else if (choice == 6 && square[1][2] == Cell.EMPTY) { square[1][2] = mark; }
            else if (choice == 7 && square[2][0] == Cell.EMPTY) { square[2][0] = mark; }
            else if (choice == 8 && square[2][1] == Cell.EMPTY) { square[2][1] = mark; }
            else if (choice == 9 && square[2][2] == Cell.EMPTY) { square[2][2] = mark; }
            
            else {
                System.out.println("Invalid move");
                --player; // set the same player to correct his move                
            }
            input.nextLine();
            ++player; // switch player        
            status = checkWinner();
        } while (status == Status.IN_PROGRESS);
        
        displayBoard();
        if (status == Status.WITH_RESULT) {
            System.out.printf(">> Player %d wins!", --player);
        } else {
            System.out.printf(">> It's a draw!");
        }
        
        System.out.println(".");
    } // end of play()

    private void displayBoard() {
        System.out.printf("\n\nTic Tac Toe\n\n");
        System.out.printf("Player 1 (X)\nPlayer 2 (O)\n\n");        
        for (int i = 0, row = 0; row < square.length; row++) {            
            for (int col = 0; col < square[row].length; col++) {
                ++i; if (square[row][col] != Cell.EMPTY) 
                    s[i] = square[row][col] == Cell.O ? 'O' : 'X';
            }
        }        
        
        System.out.printf("     |     |     \n");
        System.out.printf("  %c  |  %c  |  %c  \n", s[1], s[2], s[3]);
        System.out.printf("_____|_____|_____\n");
        System.out.printf("     |     |     \n");
        System.out.printf("  %c  |  %c  |  %c  \n", s[4], s[5], s[6]);
        System.out.printf("_____|_____|_____\n");
        System.out.printf("     |     |     \n");
        System.out.printf("  %c  |  %c  |  %c  \n", s[7], s[8], s[9]);
        System.out.printf("     |     |     \n");
    } // end of displayBoard()
    
    private Status checkWinner() {
        
        // make sure we're comparing 3 cells with values, otherwise it's considered IN_PROGRESS
             if (square[0][0] == Cell.EMPTY && square[0][1] == Cell.EMPTY && square[0][2] == Cell.EMPTY) return Status.IN_PROGRESS;
        else if (square[1][0] == Cell.EMPTY && square[1][1] == Cell.EMPTY && square[1][2] == Cell.EMPTY) return Status.IN_PROGRESS;
        else if (square[2][0] == Cell.EMPTY && square[2][1] == Cell.EMPTY && square[2][2] == Cell.EMPTY) return Status.IN_PROGRESS;
        else if (square[0][0] == Cell.EMPTY && square[1][0] == Cell.EMPTY && square[2][0] == Cell.EMPTY) return Status.IN_PROGRESS;
        else if (square[0][1] == Cell.EMPTY && square[1][1] == Cell.EMPTY && square[2][1] == Cell.EMPTY) return Status.IN_PROGRESS;
        else if (square[0][2] == Cell.EMPTY && square[1][2] == Cell.EMPTY && square[2][2] == Cell.EMPTY) return Status.IN_PROGRESS;
        else if (square[0][0] == Cell.EMPTY && square[1][1] == Cell.EMPTY && square[2][2] == Cell.EMPTY) return Status.IN_PROGRESS;
        else if (square[0][2] == Cell.EMPTY && square[1][1] == Cell.EMPTY && square[2][0] == Cell.EMPTY) return Status.IN_PROGRESS;
        
  
        // comparing 3 cells with value
             if (square[0][0] == square[0][1] && square[0][1] == square[0][2]) return Status.WITH_RESULT; // 1st row horizon
	else if (square[1][0] == square[1][1] && square[1][1] == square[1][2]) return Status.WITH_RESULT; // 2nd row horizon
	else if (square[2][0] == square[2][1] && square[2][1] == square[2][2]) return Status.WITH_RESULT; // 3rd row horizon
	else if (square[0][0] == square[1][0] && square[1][0] == square[2][0]) return Status.WITH_RESULT; // 1st col vertical
	else if (square[0][1] == square[1][1] && square[1][1] == square[2][1]) return Status.WITH_RESULT; // 2nd col vertical
	else if (square[0][2] == square[1][2] && square[1][2] == square[2][2]) return Status.WITH_RESULT; // 3rd col vertical
	else if (square[0][0] == square[1][1] && square[1][1] == square[2][2]) return Status.WITH_RESULT; // diagonal (upper-left) to (bottom-right)
	else if (square[0][2] == square[1][1] && square[1][1] == square[2][0]) return Status.WITH_RESULT; // diagonal (upper-right) to (bottom-left)
        
        // if all are filled up ... but none of them matches.
	else if ( 
                square[0][0] != Cell.EMPTY && square[0][1] != Cell.EMPTY && square[0][2] != Cell.EMPTY && 
                square[1][0] != Cell.EMPTY && square[1][1] != Cell.EMPTY && square[1][2] != Cell.EMPTY && 
                square[2][0] != Cell.EMPTY && square[2][1] != Cell.EMPTY && square[2][2] != Cell.EMPTY
                ) return Status.NO_RESULT;
	else return Status.IN_PROGRESS;
    } // end of checkWinner()
    
} // end class TicTacToe

public class Ex08_17_TicTacToe {

    public static void main(String[] args) {
        
        TicTacToe game = new TicTacToe();
        game.play();
    }
    
}
