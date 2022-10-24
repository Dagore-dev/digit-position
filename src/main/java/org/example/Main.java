package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        int even = getEvenNumbers(n1, n2);
        int odd = getOddNumbers(n1, n2);

        System.out.println("Pares: " + even);
        System.out.println("Impares: " + odd);
    }

    public static int getEvenNumbers(int n1, int n2) {
        int[] n1Array = getArrayOfDigits(n1);
        int[] n2Array = getArrayOfDigits(n2);
        int totalOfEvenNumber = getTotalOfEvenNumbers(n1Array, n2Array);
        int[] digits = new int[totalOfEvenNumber];
        int count = 0;

        for (int i = 0; i < n1Array.length; i++) {
            if (n1Array[i] % 2 == 0) {
                digits[count] = n1Array[i];
                count++;
            }
            if (n2Array[i] % 2 == 0) {
                digits[count] = n2Array[i];
                count++;
            }
        }

        return getNumberFromArrayOfDigits(digits);
    }
    public static int getOddNumbers(int n1, int n2) {
        int[] n1Array = getArrayOfDigits(n1);
        int[] n2Array = getArrayOfDigits(n2);
        int totalOfOddNumbers = getTotalOfOddNumbers(n1Array, n2Array);
        int[] digits = new int[totalOfOddNumbers];
        int count = 0;

        for (int i = 0; i < n1Array.length; i++) {
            if (n1Array[i] % 2 != 0) {
                digits[count] = n1Array[i];
                count++;
            }
            if (n2Array[i] % 2 != 0) {
                digits[count] = n2Array[i];
                count++;
            }
        }

        return getNumberFromArrayOfDigits(digits);
    }
    public static int getNumberWithEvenDigits(int n1, int n2) {
        int[] n1Digits = getArrayOfDigits(n1);
        int[] n2Digits = getArrayOfDigits(n2);
        int totalOfEvenNumbers = getTotalOfEvenNumbers(n1Digits, n2Digits);
        int[] digits = new int[totalOfEvenNumbers];
        int count = 0;

        for (int n : n1Digits) {
            if (n % 2 == 0) {
                digits[count] = n;
                count++;
            }
        }

        for (int n : n2Digits) {
            if (n % 2 == 0) {
                digits[count] = n;
                count++;
            }
        }

        return getNumberFromArrayOfDigits(digits);
    }

    public static int getTotalOfEvenNumbers(int[] n1Array, int[] n2Array) {
        int count = 0;

        for (int i : n1Array) {
            if (i % 2 == 0) {
                count++;
            }
        }

        for (int i : n2Array) {
            if (i % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static int getNumberWithOddDigits(int n1, int n2) {
        int[] n1Digits = getArrayOfDigits(n1);
        int[] n2Digits = getArrayOfDigits(n2);
        int totalOfOddNumbers = getTotalOfOddNumbers(n1Digits, n2Digits);
        int[] digits = new int[totalOfOddNumbers];
        int count = 0;

        for (int n : n1Digits) {
            if (n % 2 != 0) {
                digits[count] = n;
                count++;
            }
        }

        for (int n : n2Digits) {
            if (n % 2 != 0) {
                digits[count] = n;
                count++;
            }
        }

        return getNumberFromArrayOfDigits(digits);
    }

    public static int getTotalOfOddNumbers(int[] n1Array, int[] n2Array) {
        int count = 0;

        for (int i : n1Array) {
            if (i % 2 != 0) {
                count++;
            }
        }

        for (int i : n2Array) {
            if (i % 2 != 0) {
                count++;
            }
        }

        return count;
    }

    public static int getNumberFromArrayOfDigits (int[] nArray) {
        int length = nArray.length;
        int position = (int) (Math.pow(10, length) / 10);
        int result = 0;

        for (int n : nArray) {
            result += (n * position);
            position /= 10;
        }

        return result;
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
    public static int[] getArrayOfDigits (int n) {
        int[] reverse = getReversedArrayOfDigits(n);
        return reverseIntArray(reverse);
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