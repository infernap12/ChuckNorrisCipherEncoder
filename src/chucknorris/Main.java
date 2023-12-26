package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userSelection;
        while (true) {//menu
            System.out.println("Please input operation (encode/decode/exit):");
            userSelection = getInputLine();
            switch (userSelection) {
                case "encode" -> {
                    System.out.println("Input string:");
                    String norrisMsg = encodeNorrisMsg(getInputLine());
                    System.out.println("Encoded string:");
                    System.out.println(norrisMsg);
                }
                case "decode" -> {
                    System.out.println("Input encoded string:");
                    String decodedMsg = decodeNorrisMsg(getDecodeInput());
                    System.out.println(decodedMsg);
                }
                case "exit" -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }
                default -> {
                    System.out.printf("There is no '%s' operation%n", userSelection);
                }
            }
        }



    }

    private static String decodeNorrisMsg(String inputLine) {
        if (inputLine.equals("not valid")) {
            return inputLine;
        }
        StringBuilder decodedMsg = new StringBuilder();
        StringBuilder binaryString = new StringBuilder();
        Scanner scanner = new Scanner(inputLine);
        String inputValue;
        String value;
        String inputCount;
        int count;
        while (scanner.hasNext()) {
            inputValue = scanner.next();
            inputCount = scanner.next();
            if (inputValue.equals("0")) value = "1";
            else if (inputValue.equals("00")) {
                value = "0";
            } else {
                return "not valid";
            }
            count = inputCount.length();
            binaryString.append(value.repeat(count));
        }
        final int asciiLength = 7;
        if (binaryString.length() % asciiLength != 0) {
            return "not valid";
        }

        for (int i = 0; i < binaryString.length(); i += asciiLength) {
            String part = binaryString.substring(i, i + asciiLength);
            decodedMsg.append((char) Integer.parseInt(part, 2));
        }

        System.out.println("Decoded string:");
        return decodedMsg.toString();
    }

    private static String encodeNorrisMsg(String inputLine) {
        StringBuilder binaryString = new StringBuilder();

        for (char ch : inputLine.toCharArray()) {
            String chstring = String.format("%7s", Integer.toBinaryString(ch)).replace(' ', '0');
            binaryString.append(chstring);

        }

        StringBuilder norrisMsg = new StringBuilder();
        char previousChar = binaryString.charAt(0);
        int run = 1;
        String symbol = previousChar == '1' ? "0" : "00";

        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == previousChar) {
                run++;
            } else {
                norrisMsg.append("%s %s ".formatted(symbol, "0".repeat(run)));

                symbol = symbol.equals("0") ? "00" : "0"; //swap symbols
                previousChar = binaryString.charAt(i);
                run = 1;
            }

        }
        norrisMsg.append("%s %s ".formatted(symbol, "0".repeat(run)));


        return norrisMsg.toString().trim();
    }

    private static String getInputLine() {
        String inputLine;
        Scanner scanner = new Scanner(System.in);
        inputLine = scanner.nextLine();
        return inputLine;
    }

    private static String getDecodeInput() {
        String inputLine;
        Scanner scanner = new Scanner(System.in);
        boolean hasBadChars = scanner.hasNext("[^ 0]+");
        inputLine = scanner.nextLine();
        String[] arr = inputLine.split("\s+");
        boolean hasOddBlocks = arr.length % 2 != 0;
        boolean hasFirstBlock = arr[0].equals("0") || arr[0].equals("00");





        if (hasBadChars || hasOddBlocks || !hasFirstBlock) {
           return("not valid");
        }
        return inputLine;
    }
}



/*
C
1000011
0 0 00 0000 0 00
 */