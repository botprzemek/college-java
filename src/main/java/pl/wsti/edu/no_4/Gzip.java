package pl.wsti.edu.no_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Gzip {
    public void compress(String inputFileName, String outputFileName) {
        try (FileInputStream input = new FileInputStream(inputFileName)) {
            FileOutputStream output = new FileOutputStream(outputFileName);
            GZIPOutputStream gzip = new GZIPOutputStream(output);

            input.transferTo(gzip);

            gzip.finish();

            input.close();
            output.close();
            gzip.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void decompress(String inputFileName, String outputFileName) {
        try (FileInputStream input = new FileInputStream(inputFileName)) {
            FileOutputStream output = new FileOutputStream(outputFileName);
            GZIPInputStream gzip = new GZIPInputStream(input);

            gzip.transferTo(output);

            input.close();
            output.close();
            gzip.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
