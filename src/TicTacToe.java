package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.playGame();
    }

    public void showBoard() {
        System.out.println("\n\t      |      |");
        System.out.println("\t   " + board[1] + "  |  " + board[2] + "   |  " + board[3]);
        System.out.println("\t______|______|______");
        System.out.println("\t      |      |");
        System.out.println("\t   " + board[4] + "  |  " + board[5] + "   |  " + board[6]);
        System.out.println("\t______|______|______");
        System.out.println("\t      |      |");
        System.out.println("\t   " + board[7] + "  |  " + board[8] + "   |  " + board[9]);
        System.out.println("\t      |      |\n");
    }

    public void playGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("####|TicTacToe|####\n{PLAY}\n[EXIT]");
                String userChoiceString = scanner.nextLine().toUpperCase();
                switch (userChoiceString) {
                    case "PLAY":
                        play();
                        break;
                    case "EXIT":
                        System.exit(0);
                        break;
                    default:
                        System.out.println(ANSI_RED + "Error! Incorrect input." + ANSI_RESET);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean positionMark(int position) {
        if (board[position] == ' ') {
            return true;
        } else {
            System.out.println("This cell is already taken!");
            return false;
        }
    }

    public boolean isGameOver() {
        if (board[1] == board[2] && board[2] == board[3] && board[1] != ' ' ||
                board[4] == board[5] && board[5] == board[6] && board[4] != ' ' ||
                board[7] == board[8] && board[8] == board[9] && board[7] != ' ' ||
                board[1] == board[4] && board[4] == board[7] && board[1] != ' ' ||
                board[2] == board[5] && board[5] == board[8] && board[2] != ' ' ||
                board[3] == board[6] && board[6] == board[9] && board[3] != ' ' ||
                board[1] == board[5] && board[5] == board[9] && board[5] != ' ' ||
                board[3] == board[5] && board[5] == board[7] && board[5] != ' ') {
            return true;
        }
        return false;
    }

    public boolean tie() {
        for (int i = 1; i <= 9; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }

    public void play() {
        try (Scanner scanner = new Scanner(System.in)) {
            int userMark = 0;
            do {
                try {
                    System.out.println("Choose your mark 1- X, 2 - O");
                    userMark = scanner.nextInt();

                    if (userMark != 1 && userMark != 2) {
                        System.out.println(ANSI_RED + "Error! Please choose 1 for X or 2 for O." + ANSI_RESET);
                    }
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "Critical error! Use only int variables" + ANSI_RESET);
                    scanner.next();
                }
            } while (userMark != 1 && userMark != 2);

            while (true) {
                showBoard();
                char mark;
                if (userMark % 2 != 0) {
                    System.out.println("Player 1's chance");
                    mark = 'X';
                } else {
                    System.out.println("Player 2's chance");
                    mark = 'O';
                }

                System.out.println("Enter the position [1-9] where you want to place:");

                if (scanner.hasNextInt()) {
                    int position = scanner.nextInt();
                    if (position < 1 || position > 9) {
                        System.out.println(ANSI_RED + "Nah! Enter the position between [1-9]" + ANSI_RESET);
                    } else {
                        if (positionMark(position)) {
                            board[position] = mark;
                            userMark += 1;
                            if (isGameOver()) {
                                showBoard();
                                System.out.println(ANSI_RED + "Game over!:(" + ANSI_RESET);
                                if (tie()) {
                                    System.out.println(ANSI_YELLOW + "It's a tie!" + ANSI_RESET);
                                } else {
                                    System.out.println(ANSI_GREEN + "Player " + ((userMark % 2 == 0) ? "2" : "1") + " wins!" + ANSI_RESET);
                                }
                                System.exit(0);
                            }
                        }
                    }
                } else {
                    System.out.println(ANSI_RED + "ERROR!" + ANSI_RESET);
                    scanner.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}