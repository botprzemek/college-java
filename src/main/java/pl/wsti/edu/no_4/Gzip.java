package pl.wsti.edu.no_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Gzip {
    public static void compress(String inputFileName, String outputFileName) throws IOException {
        try (FileInputStream input = new FileInputStream(inputFileName)) {
            FileOutputStream output = new FileOutputStream(outputFileName);
            GZIPOutputStream gzip = new GZIPOutputStream(output);

            input.transferTo(gzip);

            gzip.finish();

            input.close();
            output.close();
            gzip.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static void decompress(String inputFileName, String outputFileName) throws IOException {
        try (FileInputStream input = new FileInputStream(inputFileName)) {
            FileOutputStream output = new FileOutputStream(outputFileName);
            GZIPInputStream gzip = new GZIPInputStream(input);

            gzip.transferTo(output);

            input.close();
            output.close();
            gzip.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
