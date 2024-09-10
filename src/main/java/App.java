package src.main.java;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.readFile();
    }

    private void readFile() {
        String path = this.getClass().getResource("/test.txt").getPath();
        if (path == null) {
            System.out.println("File is not found");
            return;
        }
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                System.out.printf("%5d", scanner.nextInt());
            }
            System.out.println();
        } catch (Exception e) {
            System.out.printf("Uuupsy! Exception: %s.%n", e.getMessage());
        }
    }
}