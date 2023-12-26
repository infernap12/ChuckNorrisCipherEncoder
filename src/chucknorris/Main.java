package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input string:");
        String binaryString = getBinaryString();
        System.out.println("The result:");
        String norrisMsg = getNorrisMsg(binaryString);
        System.out.println(norrisMsg);
    }

    private static String getNorrisMsg(String binaryString) {
        StringBuilder norrisMsg = new StringBuilder();
        char previousChar = binaryString.charAt(0);
        int run = 1;
        String symbol = previousChar == '1' ? "0" : "00";
        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == previousChar) {
                run++;
            } else {
                norrisMsg.append("%s %s ".formatted(symbol,"0".repeat(run)));

                symbol = symbol.equals("0") ? "00" : "0"; //swap symbols
                previousChar = binaryString.charAt(i);
                run = 1;
            }

        }
        norrisMsg.append("%s %s ".formatted(symbol,"0".repeat(run)));




        return norrisMsg.toString().trim();
    }

    private static String getBinaryString() {
        String inputLine;
        Scanner scanner = new Scanner(System.in);
        inputLine = scanner.nextLine();

        StringBuilder binaryString = new StringBuilder();

        for (char ch : inputLine.toCharArray()) {
            String chstring = String.format("%7s", Integer.toBinaryString(ch)).replace(' ','0');
            binaryString.append(chstring);

        }
        return binaryString.toString();
    }
}



/*
C
1000011
0 0 00 0000 0 00
 */