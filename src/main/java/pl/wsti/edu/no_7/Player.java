package pl.wsti.edu.no_7;

import java.net.*;
import java.io.*;

public class Player implements Runnable {
    private int[][] board;
    private boolean[][] checked;

    private PrintWriter out;
    private BufferedReader in;
    private final Socket connection;

    public Player(Socket connection) {
        this.connection = connection;

        setBoard();

        try {
            this.out = new PrintWriter(connection.getOutputStream(), true);
            this.in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setBoard() {
        board = new int[11][11];
        checked = new boolean[11][11];

        int row;
        int column;
        int score = 0;

        while (score < 10) {
            row = (int) (Math.random() * 9) + 1;
            column = (int) (Math.random() * 9) + 1;

            if (board[row][column] >= 100) {
                continue;
            }

            board[row][column] = 100;

            ++board[row - 1][column - 1];
            ++board[row - 1][column];
            ++board[row - 1][column + 1];
            ++board[row][column - 1];
            ++board[row][column + 1];
            ++board[row + 1][column - 1];
            ++board[row + 1][column];
            ++board[row + 1][column + 1];

            ++score;
        }
    }

    public void run() {
        int row;
        int column;
        int score = 0;
        boolean end = false;

        String message;
        String odp;

        try {
            while (!end) {
                message = in.readLine();

                if (message == null) {
                    end = true;

                    continue;
                }

                try {
                    score = Integer.parseInt(message);
                    row = ((score - 1) / 9) + 1;
                    column = (score - 1) % 9 + 1;
                }
                catch (NumberFormatException e) {
                    row = 200;
                    column = 200;
                }

                if (!((row>=1) && (row<=9) && (column>=1) && (column<9))) {
                    continue;
                }

                if (board[row][column] >= 100) {
                    end = true;
                }
                else {
                    if (!checked[row][column]) ++score;
                }

                checked[row][column] = true;
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                connection.close();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
