package Sudoku;

import java.util.Random;
import java.util.Scanner;
import static Sudoku.BackTrackingAlgorithm.printBoard;

public class Sudoku {

    private static final int BOARD_SIZE = 9;
    public static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_START_INDEX = 0;

    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        System.out.print("Enter the number of Boards you want to test: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.print("Enter the number of spaces in the board (preferably over 65): ");
        int emptyCells = scanner.nextInt();
        Sudoku sudoku = new Sudoku();
        sudoku.Creator(value, emptyCells);
    }

    public void Creator(int n, int cells){
        long start = System.currentTimeMillis();
        int ValCreated = 0;
        int InvCreated = 0;
        int SolvableBrd = 0;
        System.out.println("For N = " + n + " Boards");
        for (int i = 0; i < n; i++){
            int[][] brd;
            brd = EmptyBoard(cells);
            if (isValidBoard(brd)) {
                ValCreated++;
                int[][] temp = CopyBoard(brd);
                if (isSolvableBoard(brd)) {
                    SolvableBrd++;
                    System.out.println("Board Number: " + i);
                    printBoard(temp);
                    System.out.println("Solution of Board Number: " + i);
                    printBoard(brd);
                    System.out.println("=========================");
                }
            }
            else
                InvCreated++;
        }

        long end = System.currentTimeMillis();
        long totaltime = (end - start);
        System.out.println("Empty cells per board: " + cells);
        System.out.println("Valid Boards Created: " + ValCreated);
        System.out.println("Solvable Boards Created: " + SolvableBrd);  //Only shows any difference on big N values
        System.out.println("Invalid Boards Created: " + InvCreated);
        System.out.println("Total Time Elapsed: " + totaltime/1000f + " (seconds)");
    }

    public int[][] CopyBoard(int[][] board){
        int[][] newbrd = new int[9][9];
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                newbrd[row][column] = board[row][column];
            }
        }
        return newbrd;
    }

    public boolean isValidBoard(int[][] brd){
        //Checking Rows
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++){
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++){
                if (!(brd[row][column] >= NO_VALUE && brd[row][column] <= MAX_VALUE)) return false;

                for(int k = BOARD_START_INDEX; k < column; k++) {
                    if (brd[row][k] == brd[row][column] && brd[row][k] != NO_VALUE) return false;
                }
            }
        }

        //Checking Columns
        for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++){
            for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++){
                if (!(brd[row][column] >= NO_VALUE && brd[row][column] <= MAX_VALUE)) return false;

                for(int k = BOARD_START_INDEX; k < row; k++) {
                    if (brd[k][column] == brd[row][column] && brd[k][column] != NO_VALUE) return false;
                }
            }
        }

        //Checking Subsections
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row+=SUBSECTION_SIZE){
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column+=SUBSECTION_SIZE){
                for(int rowi = row; rowi < row + SUBSECTION_SIZE; rowi++){
                    for(int columni = column; columni < column + SUBSECTION_SIZE; columni++){
                        for (int k = column; k < column + SUBSECTION_SIZE; k++)
                            for (int j = row; j < row + SUBSECTION_SIZE; j++)
                                if ((brd[rowi][columni] != NO_VALUE) && (brd[rowi][columni] == brd[j][k]) && (columni != k) && (rowi != j)) return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isSolvableBoard(int[][] board){
        BackTrackingAlgorithm solver = new BackTrackingAlgorithm();
        if (!isValidBoard(board)) {
            return false;
        }
        return solver.solve(board);
    }

    private int[][] EmptyBoard(int x){
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++){
            for(int column = BOARD_START_INDEX; column < BOARD_SIZE; column++){
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(MAX_VALUE-MIN_VALUE+1) + MIN_VALUE;
                board[row][column] = randomInt;
            }
        }
        for (int i = 0; i < x;){
            Random ran = new Random();
            int index = ran.nextInt(81);
            int row = index / BOARD_SIZE;
            int column = index % BOARD_SIZE;
            if (board[row][column] != 0 ) {
                board[row][column] = 0;
                i++;
            }
        }
        return board;
    }
}
