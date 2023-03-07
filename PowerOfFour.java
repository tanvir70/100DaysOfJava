package swe;

import java.util.Scanner;

public class PowerOfFour {

    public static boolean powerOfFourDetector(int input) {
        int oddBitMask = 0x55555555;
        // 0x55555555 is a 32-bit number : 1010101010101010101010101010101
        if (input <= 0) {
            return false;
        }
        if ((input & (input - 1)) == 0) {
            if ((input & oddBitMask) == input) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input: ");
        int x = scan.nextInt();
        System.out.print("Output: " + powerOfFourDetector(x));
    }
}
