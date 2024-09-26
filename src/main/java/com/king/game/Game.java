package com.king.game;

//NAVINDU KAVISHKA
//INDEX : 220100003
import java.util.Scanner;

public class Game {

    public static void dashboard() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t#######################################################################\n\t#\t\t\tWELCOME TO TIC TAC TOE GAME\t\t\t#");
            System.out.println("\t#\t\t\tDevelop by NAVINDU KAVISHKA\t\t\t#\n\t#######################################################################\n\n\n");

            System.out.println("\t\t---Main Menu---");
            System.out.println("\t\t[1] How to Play?...");
            System.out.println("\t\t[2] Start Game...");
            System.out.println("\t\t[3] Exit...\n");

            System.out.print("Input Option : ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n\n");
                    System.out.println("\t -> This Game for two Players.Firstly user should input row number(1 to 3) and column number(1 to 3)  ");
                    System.out.println("\t -> The Player who aligns three of their symbols in a row first is the Winner! ");
                    System.out.println("\n\t***** Let's Start... *****\n");
                    break;
                case 2:
                    startGame();
                    break;
                case 3:
                    System.out.println("\n\t GOOD BYE...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid optin... Try again!...");

            }
        }
    }

    public static void startGame() {
        Scanner input = new Scanner(System.in);

        //char [][] board = new char[3][3];
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = '1';
        boolean gameEnded = false;

        while (!gameEnded) {
            printing(board);
            movement(board, currentPlayer);
            gameEnded = checkingWin(board, currentPlayer);

            if (!gameEnded) {
                currentPlayer = (currentPlayer == '1') ? '2' : '1';
            }
        }

        printing(board);
        System.out.println("\nGame over! Player " + currentPlayer + " win!");
        System.out.print("\nDo you want to goto Dashboard (Y/N) : ");
        String option = input.next();
        if (option.equalsIgnoreCase("Y")) {
            dashboard();
        } else {
            System.out.println("\n\t GOOD BYE...");
            System.exit(0);
        }

    }

    public static void printing(char[][] board) {
        System.out.println("\n\n\tTIC TAC TOE\n*************************\n");
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                System.out.print("|");
            }
            System.out.print("\b\n");
            if (i < board.length - 1) {
                System.out.println("  \t--- --- ---");
            }
        }
    }

    public static void movement(char[][] board, char currentPlayer) {
        Scanner input = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.print("\nPlayer " + currentPlayer + ", Enter your move (row) : ");
            row = input.nextInt() - 1;
            System.out.print("\nPlayer " + currentPlayer + ", Enter your move (column) : ");
            col = input.nextInt() - 1;

            System.out.println("\n");

            if (row < 0 || col < 0 || row >= board.length || col >= board[row].length) {
                System.out.println("Invalid row or column. Try again.");
            } else if (board[row][col] != ' ') {
                System.out.println("This is already Marked. Try again.");
            } else {
//                if (currentPlayer=='1') {
//                    currentPlayer='X';
//                }if (currentPlayer=='2') {
//                    currentPlayer='O';
//                }
                board[row][col] = (currentPlayer == '1') ? 'X' : 'O';

                break;
            }
        }
    }

    public static boolean checkingWin(char[][] board, char player) {
        Scanner input = new Scanner(System.in);

        char currentPlayer = 0;
        if (player == '1') {
            currentPlayer = 'X';
        }
        if (player == '2') {
            currentPlayer = 'O';
        }
        // Checking row wise and column wise
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Checking diagonal 1
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        // Check diagonal 2
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        // Check for draw
        boolean boardFull = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    boardFull = false;
                    break;
                }
            }
        }

        if (boardFull) {
            printing(board);
            System.out.println("The Game is a draw!");
            System.out.print("\nDo you want to goto Dashboard (Y/N) : ");
            String option = input.next();
            if (option.equalsIgnoreCase("Y")) {
                dashboard();
            } else {
                System.out.println("\n\t GOOD BYE...");
                System.exit(0);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        dashboard();
        //char [][] board = new char[3][3];
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = '1';
        boolean gameEnded = false;

        while (!gameEnded) {
            printing(board);
            movement(board, currentPlayer);
            gameEnded = checkingWin(board, currentPlayer);

            if (!gameEnded) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                //currentPlayer = (currentPlayer == '1') ? '2' : '1';
            }
        }

        printing(board);
        System.out.println("Game over! Player " + currentPlayer + " win!");
    }

}
