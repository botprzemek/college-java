package pl.wsti.edu.no_7;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    boolean isGameRunning;
    int fieldsCount;

    public Client(Socket connection) {
        isGameRunning = true;
        fieldsCount = 0;

        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            in.readLine();

            while (isGameRunning && fieldsCount < 71) {
                String input = scanner.nextLine();
                out.println(input);
                String response = in.readLine();

                if (response != null && !response.equalsIgnoreCase("boom")) {
                    fieldsCount++;

                    continue;
                }

                isGameRunning = false;
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}