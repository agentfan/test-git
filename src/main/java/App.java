package src.main.java;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] inputted = app.readFile();
        System.out.println("End.");
    }

    private int[] readFile() {
        String path = Optional.ofNullable(this.getClass().getResource("/test.txt"))
                .map(URL::getPath)
                .orElse(null);
        if (path == null) {
            System.out.println("File is not found");
            return null;
        }
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            int[] result = new int[100];
            int i = 0;
            while (scanner.hasNextInt()) {
                result[i] = scanner.nextInt();
                System.out.printf("%5d", result[i]);
                i++;
            }
            System.out.println();
            return result;
        } catch (Exception e) {
            System.out.printf("Uuupsy! Exception: %s.%n", e.getMessage());
            return null;
        }
    }
}