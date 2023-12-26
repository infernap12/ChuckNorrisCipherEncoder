package chucknorris;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String input;
        System.out.println("Input string:");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        System.out.println("The result:");
        for (char ch : input.toCharArray()) {
            String chstring = String.format("%7s", Integer.toBinaryString((int)ch)).replace(' ','0');
            System.out.printf("%c = %7s%n", ch, chstring);

        }

    }
}