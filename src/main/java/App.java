package src.main.java;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        List<Integer> result = app.readFile();
        System.out.println("End.");
    }

    private List<Integer> readFile() {
        String path = Optional.ofNullable(this.getClass().getResource("/test.txt"))
                .map(URL::getPath)
                .orElse(null);
        if (path == null) {
            System.out.println("File is not found");
            return null;
        }
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            List<Integer> result = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                System.out.printf("%5d", x);
                result.add(x);
            }
            System.out.println();
            return result;
        } catch (Exception e) {
            System.out.printf("Uuupsy! Exception: %s.%n", e.getMessage());
            return null;
        }
    }
}