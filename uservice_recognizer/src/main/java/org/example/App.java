package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sf = new Scanner(System.in);
        String leftAlignFormat = "| %-55s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-65s |%n";
        while (true) {
            System.out.printf("Serch: ");
            String searchable = sf.nextLine().toLowerCase(Locale.ROOT);
            if (searchable.equals("exit")) {
                break;
            }

            Scanner scanner = new Scanner(new FileInputStream("data/cap.csv"));
            String[] headers = scanner.nextLine().split(";");
            System.out.format(leftAlignFormat, headers);

            int count = 0;
            while (scanner.hasNextLine()) {
                String[] position = scanner.nextLine().split(";", -1);

                if (position[0].toLowerCase(Locale.ROOT).indexOf(searchable) > -1) {
                    System.out.format(leftAlignFormat, position);
                    count++;
                }

            }
            System.out.println(count + " results");
        }
    }
}
