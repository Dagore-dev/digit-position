package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n = scanner.nextInt();

        System.out.print("Dime un digito (0 - 9) del anterior número y te digo su posición: ");
        int digitToSearch = scanner.nextInt();

        try {
            int position = getIndexOf(digitToSearch, n);

            if (position != -1) {
                System.out.printf("La posición de %s en %s es %s.", digitToSearch, n, position);
            } else {
                System.out.printf("El digito %s no se encuentra en el número %s.", digitToSearch, n);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static int getNumberOfDigits (int n) {
        if (n != 0){
            int count = 0;
            int current = Math.abs(n);

            while (current > 0) {
                current = current / 10;
                count++;
            }

            return count;
        } else {
            return 1;
        }
    }
    public static int[] getReversedArrayOfDigits(int n) {
        int digits = getNumberOfDigits(n);
        int[] digitsArray = new int[digits];

        if (n != 0){
            int current = Math.abs(n);
            int count = 0;

            while (current > 0) {
                digitsArray[count] = current % 10;
                count++;
                current /= 10;
            }
        } else {
            digitsArray[0] = 0;
        }

        return digitsArray;
    }
    public static int[] reverseIntArray(int[] array){
        int length = array.length;

        if (length != 0){
            int[] result = new int[length];

            for (int i = 0; i < length; i++) {
                result[length - i - 1] = array[i];
            }

            return result;
        } else {
            return new int[0];
        }
    }
    public static int getIndexOf (int digitToSearch, int number) throws IllegalArgumentException{
        if (digitToSearch < 0 || digitToSearch > 9) {
            throw new IllegalArgumentException("El `digitToSearch` debe ser un entero entre 0 y 9, ambos incluidos.");
        }

        int result = -1;
        int[] reversedDigitArray = getReversedArrayOfDigits(number);
        int[] digitArray = reverseIntArray(reversedDigitArray);

        for (int i = 0; i < digitArray.length; i++) {
            if (digitArray[i] == digitToSearch) {
                return i;
            }
        }

        return result;
    }
}