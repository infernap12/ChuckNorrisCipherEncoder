package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input encoded string:");
        String decodedMsg = decodeNorrisMsg(getInputLine());
        System.out.println("The result:");
        System.out.println(decodedMsg);


//        System.out.println("Input string:");
//        String binaryString = getBinaryString();
//        System.out.println("The result:");
//        String norrisMsg = encodeNorrisMsg(binaryString);
//        System.out.println(norrisMsg);
    }

    private static String decodeNorrisMsg(String inputLine) {
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
            value = inputValue.equals("0") ? "1" : "0";
            count = inputCount.length();
            binaryString.append(value.repeat(count));
        }
        final int asciiLength = 7;

        for (int i = 0; i < binaryString.length(); i += asciiLength) {
            String part = binaryString.substring(i, i + asciiLength);
            decodedMsg.append((char) Integer.parseInt(part,2));
        }




        return decodedMsg.toString();
    }

    private static String encodeNorrisMsg(String inputLine) {
        StringBuilder binaryString = new StringBuilder();

        for (char ch : inputLine.toCharArray()) {
            String chstring = String.format("%7s", Integer.toBinaryString(ch)).replace(' ','0');
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
                norrisMsg.append("%s %s ".formatted(symbol,"0".repeat(run)));

                symbol = symbol.equals("0") ? "00" : "0"; //swap symbols
                previousChar = binaryString.charAt(i);
                run = 1;
            }

        }
        norrisMsg.append("%s %s ".formatted(symbol,"0".repeat(run)));




        return norrisMsg.toString().trim();
    }
        private static String getInputLine() {
        String inputLine;
        Scanner scanner = new Scanner(System.in);
        inputLine = scanner.nextLine();
        return inputLine;
    }
}



/*
C
1000011
0 0 00 0000 0 00
 */