import java.util.Scanner;

public class TicTacToe{

  static Scanner scan = new Scanner(System.in);
  public static void main (String[] args){

    System.out.println("\nLet's play tic tac toe");
    char[][] board = {
			{ '_', '_', '_' },
			{ '_', '_', '_' },
			{ '_', '_', '_' }
	  };
    printBoard(board);

    for(int i = 0; i < 9; i++){
      if(i % 2 == 0){
        System.out.println("Turn: X");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'X';
      }else{
        System.out.println("Turn: O");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'O';
      }
      printBoard(board);

      int count = checkWin(board);
      if(count == 3){
        System.out.println("X wins");
        break;
      }else if(count == -3){
        System.out.println("O wins");
        break;
      }else if(i == 8){
        System.out.println("It's a tie");
      }
    }

    scan.close();
  }

  public static void printBoard(char[][] array){
    System.out.print("\n");
    for(int i = 0; i < array.length; i++){
      System.out.print("\t");
      for(int j = 0; j < array[i].length; j++){
        System.out.print(array[i][j]+" ");
      }
      System.out.print("\n\n");
    }
  }

  public static int[] askUser(char[][] array){
    System.out.print("Pick a row and column number: ");
    int row = scan.nextInt();
    int pos = scan.nextInt();
    while(array[row][pos] != '_'){
      System.out.print("Position taken, try another position: ");
      row = scan.nextInt();
      pos = scan.nextInt();
    }
    return new int[] {row, pos};
  }

  public static int checkWin(char[][] array){

    int rows = checkRows(array); 
    if (Math.abs(rows) == 3){
      return rows;
    }

    int columns = checkColumns(array);
    if (Math.abs(columns) == 3){
      return columns;  
    }

    int leftDiagonal = checkLeft(array);
    if (Math.abs(leftDiagonal) == 3){
      return leftDiagonal;
    }

    int rightDiagonal = checkRight(array);
    if (Math.abs(rightDiagonal) == 3){
     return rightDiagonal;
    }
     return -1;
  }

  public static int checkRows(char[][] array) {
    int count = 0;
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        if(array[i][j] == 'X'){
          count++;
        }else if(array[i][j] == 'O'){
          count--;
        }
      }

      if(Math.abs(count) == 3){
        return count;
      }else{
        count = 0;
      }
    }
    return count;
  }

  public static int checkColumns(char[][] array) {
    int count = 0;
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        if(array[j][i] == 'X'){
          count++;
        }else if(array[i][j] == 'O'){
          count--;
        }
      }

      if(Math.abs(count) == 3){
        return count;
      }else{
        count = 0;
      }
    }
    return count;
  }

  public static int checkLeft(char[][] array) {
    int count = 0;
    for(int i = 0; i < 3; i++){
      if(array[i][i] == 'X'){
        count++;
      }else{
        count--;
      }

      if(Math.abs(count) == 3){
        return count;
      }else if(array[i][i] == 'O'){
        count = 0;
      }
    }
    return count;
  }

  public static int checkRight(char[][] array) {
    int count = 0;
    for(int i = 0; i < 3; i++){
      for(int j = 2; j >= 0; j--){
        if(array[i][j] == 'X'){
          count++;
        }else if(array[i][j] == 'O'){
          count--;
        }
      }

      if(Math.abs(count) == 3){
        return count;
      }else{
        count = 0;
      }
    }
    return count;
  }

}