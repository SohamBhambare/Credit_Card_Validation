import java.util.Scanner;

public class Credit_Card_Validation {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter a credit card number as a long integer: ");
        long num = kb.nextLong();

        if (num != 0) {
            if (isValid(num)) {
                System.out.println(num + " is valid.");
            } else {
                System.out.println(num + " is invalid.");
            }
        }

    }

    public static boolean isValid(long number) {

        boolean valid =
            (getSize(number) >= 13 && getSize(number) <= 16) &&
            (prefixMatched(number, 4) || prefixMatched(number, 5) ||
            prefixMatched(number, 37) || prefixMatched(number, 6)) &&
            ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);

        return valid;

    }

    public static int sumOfDoubleEvenPlace(long number) {

        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return sum;

    }

    public static int getDigit(int number) {

        int digit1 = number / 10;
        int digit2 = number % 10;

        if (digit1 == 0) {
            return number;
        } else {
            return digit1 + digit2;
        }

    }

    public static int sumOfOddPlace(long number) {

        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return sum;

    }

    public static boolean prefixMatched(long number, int d) {

        if (getPrefix(number, getSize(d)) == d) {
            return true;
        }
        return false;

    }

    public static int getSize(long number) {

        int no_of_digits = 1;
        while ((number = number / 10) != 0) {
            no_of_digits++;
        }
        return no_of_digits;

    }

    public static long getPrefix(long number, int k) {

        int no_of_digits = getSize(number);
        return number / (long) (Math.pow(10.0, (double) (no_of_digits - k)));

    }

}
