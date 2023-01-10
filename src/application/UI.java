package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[97m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_GREY_BACKGROUND = "\u001B[100m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
        }
    }

    public static void printMatch(ChessMatch chessMatch) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());
        System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
    }

    public static void printBoard(ChessPiece[][] pieces) {
        System.out.println(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "    a b c d e f g h    " + ANSI_RESET);
        for(int i = 0; i < pieces.length; i++) {
            System.out.print(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + " " + (8 - i) + " " + ANSI_RESET);
            for(int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.print(ANSI_GREY_BACKGROUND + " " + ANSI_RESET);
            System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " " + (8 - i) + " " + ANSI_RESET);
            System.out.println();
        }
        System.out.println(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "    a b c d e f g h    " + ANSI_RESET);
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        System.out.println(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "    a b c d e f g h    " + ANSI_RESET);
        for(int i = 0; i < pieces.length; i++) {
            System.out.print(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + " " + (8 - i) + " " + ANSI_RESET);
            for(int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.print(ANSI_GREY_BACKGROUND + " " + ANSI_RESET);
            System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " " + (8 - i) + " " + ANSI_RESET);
            System.out.println();
        }
        System.out.println(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "    a b c d e f g h    " + ANSI_RESET);
    }

    private static void printPiece(ChessPiece piece, boolean background) {
        if(piece == null) {
            if (background) {
                System.out.print(ANSI_GREY_BACKGROUND + " " + ANSI_YELLOW_BACKGROUND + "-" + ANSI_RESET);
            } else {
                System.out.print(ANSI_GREY_BACKGROUND + " -" + ANSI_RESET);
            }

        } else {
            if (piece.getColor() == Color.WHITE) {
                if (background) {
                    System.out.print(ANSI_GREY_BACKGROUND + " " + ANSI_YELLOW_BACKGROUND + ANSI_WHITE + piece + ANSI_RESET);
                } else {
                    System.out.print(ANSI_GREY_BACKGROUND + ANSI_WHITE + " " + piece + ANSI_RESET);
                }
            }
            else {
                if (background) {
                    System.out.print(ANSI_GREY_BACKGROUND + " " + ANSI_YELLOW_BACKGROUND + ANSI_BLACK + piece + ANSI_RESET);
                } else {
                    System.out.print(ANSI_GREY_BACKGROUND + ANSI_BLACK + " " + piece + ANSI_RESET);
                }
            }
        }
    }
}
