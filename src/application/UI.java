package application;

import chess.ChessPiece;
import chess.Color;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[97m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_GREY_BACKGROUND = "\u001B[100m";

    public static void printBoard(ChessPiece[][] pieces) {
        System.out.println(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "    a b c d e f g h    " + ANSI_RESET);
        for(int i = 0; i < pieces.length; i++) {
            System.out.print(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + " " + (8 - i) + " " + ANSI_RESET);
            for(int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]);
            }
            System.out.print(ANSI_GREY_BACKGROUND + " " + ANSI_RESET);
            System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " " + (8 - i) + " " + ANSI_RESET);
            System.out.println();
        }
        System.out.println(" " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "    a b c d e f g h    " + ANSI_RESET);
    }

    private static void printPiece(ChessPiece piece) {
        if(piece == null) {
            System.out.print(ANSI_GREY_BACKGROUND + " -" + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_GREY_BACKGROUND + ANSI_WHITE + " " + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_GREY_BACKGROUND + ANSI_BLACK + " " + piece + ANSI_RESET);
            }
        }
    }
}
