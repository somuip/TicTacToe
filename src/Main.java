import java.util.Scanner;

public class Main {
	
		static char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
		static int turns = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Tic Tac Toe");
		
		printBoard();
		boolean result = false;
		while(turns<9) {
			System.out.println("Player" + ((turns % 2 == 0) ? "X" : "O") + ", enter the row and column of your move: ");
			int row = sc.nextInt() - 1;
		    int col = sc.nextInt() - 1;
		    if (board[row][col] == ' ') {
		      board[row][col] = (turns % 2 == 0) ? 'X' : 'O';
		      turns++;
		      printBoard();
		      if (checkForWin()) {
		    	  result = true;
		        System.out.println("Player " + ((turns % 2 == 0) ? "O" : "X") + " wins!");
		        break;
		      }
		    } else {
		      System.out.println("That space is already occupied. Try again.");
		    }
		  }
		if(!result) {
			System.out.println("The game is draw");
		}
		
	}
	public static void printBoard(){
		    System.out.println("  1 2 3");
		    System.out.println(" +-+-+-+");
		    for (int i = 0; i < 3; i++) {
		      System.out.print((i + 1) + "|" + board[i][0] + "|" + board[i][1] + "|" + board[i][2] + "|");
		      System.out.println();
		      System.out.println(" +-+-+-+");
		    }
	}
	public static boolean checkForWin() {
		  // Check rows
	    for (int i = 0; i < 3; i++) {
	      if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
	        return true;
	      }
	    }

	    // Check columns
	    for (int i = 0; i < 3; i++) {
	      if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
	        return true;
	      }
	    }

	    // Check diagonals
	    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
	      return true;
	    }
	    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
	      return true;
	    }

	    return false;
	  }
}

// oops concept involved is encapsulation and abstraction.
// Encapsulation is used to hide the implementation details of the game and provide a clean interface for the user to interact with the game. This is achieved by creating a class Main that contains all the game logic and methods, such as checkForWin() and printBoard().

// Abstraction is used to simplify the game logic for the user by hiding the underlying details and providing a simple, user-friendly interface. For example, the user is only required to enter the row and column of their move, and the game takes care of the rest.
