import java.util.Scanner;

public class NumberToWords {
    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] teens = {
            "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число (максимальне - 1 мільярд): ");
        double number = scanner.nextDouble();

        int dollars = (int) number;
        int cents = (int) ((number - dollars) * 100);

        if (dollars == 0) {
            System.out.println("zero dollars");
        } else {
            String dollarWords = convertToWords(dollars);
            System.out.println(dollarWords + " dollars");
        }

        if (cents > 0) {
            String centWords = convertToWords(cents);
            System.out.println(centWords + " cents");
        }

        scanner.close();
    }

    private static String convertToWords(int number) {
        if (number < 10) {
            return units[number];
        } else if (number < 20) {
            return teens[number - 10];
        } else if (number < 100) {
            return tens[number / 10] + ((number % 10 != 0) ? "-" + units[number % 10] : "");
        } else if (number < 1000) {
            return units[number / 100] + " hundred" + ((number % 100 != 0) ? " " + convertToWords(number % 100) : "");
        } else if (number < 1000000) {
            return convertToWords(number / 1000) + " thousand" + ((number % 1000 != 0) ? " " + convertToWords(number % 1000) : "");
        } else if (number < 1000000000) {
            return convertToWords(number / 1000000) + " million" + ((number % 1000000 != 0) ? " " + convertToWords(number % 1000000) : "");
        } else {
            return "Number too large";
        }
    }
}

