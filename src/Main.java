import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 8 bit number in Hex");
        String input = scanner.nextLine();
        int number = parseInt(input);
        int sBoxOutput = Cipher.sBoxTransformation(number);
        System.out.println("S-box output: " + Integer.toHexString(sBoxOutput));

        int pBoxOutput = Cipher.pBoxTransformation(sBoxOutput);
        System.out.println("P-box output: " + Integer.toHexString(pBoxOutput));

        int reversePBoxOutput = Cipher.reversePBoxTransformation(pBoxOutput);
        System.out.println("Reverse P-box output: " + Integer.toHexString(reversePBoxOutput));

        int reverseSBoxOutput = Cipher.reverseSBoxTransformation(reversePBoxOutput);
        System.out.println("Reverse S-box output: " + Integer.toHexString(reverseSBoxOutput));
    }
    private static int parseInt(String str) {
        int n;
        try {
            n = Integer.parseInt(str, 16);
        } catch(NumberFormatException exception) {
            throw new IllegalArgumentException("Invalid input value");
        }
        return n;
    }
}