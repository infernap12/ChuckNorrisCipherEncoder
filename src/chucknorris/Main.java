package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        for (char ch : input.toCharArray()) {
            System.out.print(ch + " ");

        }
        System.out.println();
    }
}