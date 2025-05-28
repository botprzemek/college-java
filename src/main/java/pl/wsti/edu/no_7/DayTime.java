package pl.wsti.edu.no_7;

import java.io.*;
import java.net.*;
import java.util.Date;

public class DayTime {
    public static void main(String[] args) {
        String host = (args.length > 0) ? args[0] : "time-a.nist.gov";

        try (Socket socket = new Socket(host, 37)) {
            InputStream input = socket.getInputStream();
            long time = 0;

            for (int i = 0; i < 4; i++) {
                int b = input.read();

                if (b == -1) {
                    throw new IOException("No data from server.");
                }

                time = (time << 8) | b;
            }

            long unixTime = time - 2208988800L;
            Date date = new Date(unixTime * 1000L);

            System.out.println("Date and time (UTC): " + date);
        } catch (UnknownHostException e) {
            System.err.println("Host not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
