package Sudoku;

/*
 * The Code provided for the Backtracking Algorithm
 * is provided from: is from: https://www.baeldung.com/java-sudoku
 * and used to solve the sudoku puzzle.
 * I have added a few methods to check the input
 * and the solvability of the sudoku board
 */

import java.util.Random;

public class BacktrackingAlgorithm {

    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_START_INDEX = 0;

    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private static final int[][] board = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
    };

    public static void main(String[] args) {
        //Testing!
        int[][] brd;
        brd = EmptyBoard(45);
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                System.out.print(brd[row][column] + " ");
            }
            System.out.println();
        }
        boolean f = isValidBoard(board);
        System.out.println(f);
        System.exit(0);

        BacktrackingAlgorithm solver = new BacktrackingAlgorithm();
        solver.solve(board);
        solver.printBoard();
    }

    static boolean isValidBoard(int[][] brd){
        //Checking Rows
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++){
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++){
                if (!(brd[row][column] >= 0 && brd[row][column] <= MAX_VALUE)) return false;

                for(int k = BOARD_START_INDEX; k < column; k++) {
                    if (brd[row][k] == brd[row][column] && brd[row][k] != 0) return false;
                }
            }
        }

        //Checking Columns
        for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++){
            for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++){
                if (!(brd[row][column] >= 0 && brd[row][column] <= MAX_VALUE)) return false;

                for(int k = BOARD_START_INDEX; k < row; k++) {
                    if (brd[k][column] == brd[row][column] && brd[k][column] != 0) return false;
                }
            }
        }

        //Checking Subsections
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row+=3){
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column+=3){
                for(int rowi = row; rowi < row + 3; rowi++){
                    for(int columni = column; columni < column + 3; columni++){
                        for (int k = column; k < column + 3; k++)
                            for (int j = row; j < row + 3; j++)
                                if ((brd[rowi][columni] != 0) && (brd[rowi][columni] == brd[j][k]) && (columni != k) && (rowi != j)) return false;
                    }
                }
            }
        }

        return true;
    }

    boolean isSolvableBoard(int[][] board){

        return true;
    }

    static int[][] EmptyBoard(int x){
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

    private void printBoard() {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    public boolean solve(int[][] board) {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                if (board[row][column] == NO_VALUE) {
                    for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && solve(board)) {
                            return true;
                        }
                        board[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int column) {
        return rowConstraint(board, row) &&
                columnConstraint(board, column) &&
                subsectionConstraint(board, row, column);
    }

    private boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

        int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    private boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            if (!checkConstraint(board, row, constraint, column)) {
                return false;
            }
        }
        return true;
    }

    private boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
            if (!checkConstraint(board, row, constraint, column)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {
        if (board[row][column] != NO_VALUE) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
