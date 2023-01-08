import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while((!choice.equals("2") && (!choice.equals("8")) && (!choice.equals("10")) && (!choice.equals("16")))){
            System.out.println("This is an invalid response.Please try again.\n");
            System.out.print("Enter the base of your number (2, 8, 10 or 16): ");
            choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (base == 2) {
                if (c != '0' && c != '1') {
                    System.out.println("This is an invalid response. Please try again.");
                    System.out.print("Enter your number: ");
                    number = s.nextLine();
                    i = -1;
                }
            } else if (base == 8) {
                if (c < '0' || c > '7') {
                    System.out.println("This is an invalid response. Please try again.");
                    System.out.print("Enter your number: ");
                    number = s.nextLine();
                    i = -1;
                }
            } else if (base == 16) {
                if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F'))) {
                    System.out.println("This is an invalid response. Please try again.");
                    System.out.print("Enter your number: ");
                    number = s.nextLine();
                    i = -1;
                }
            }
        }

       // int n = Integer.parseInt(number);
        String n = number;
        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();

        if(base == 2){
            System.out.println("\nDecimal Number: " + Arrays.toString(nc.convertToDecimal()));
            System.out.println("Octal Number: " + Arrays.toString(nc.convertToOctal()));
            System.out.println("Hexadecimal Number: " + Arrays.toString(nc.convertToHexadecimal()));
        }
        if(base == 8){
            System.out.println("\nDecimal Number: " + Arrays.toString(nc.convertToDecimal()));
            System.out.println("Binary Number: " + Arrays.toString(nc.convertToBinary()));
            System.out.println("Hexadecimal Number: " + Arrays.toString(nc.convertToHexadecimal()));
        }
        if(base == 10){
            System.out.println("\nBinary Number: " + Arrays.toString(nc.convertToBinary()));
            System.out.println("Octal Number: " + Arrays.toString(nc.convertToOctal()));
            System.out.println("Hexadecimal Number: " + Arrays.toString(nc.convertToHexadecimal()));
        }
        if(base == 16){
            System.out.println("\nDecimal Number: " + Arrays.toString(nc.convertToDecimal()));
            System.out.println("Binary Number: " + Arrays.toString(nc.convertToBinary()));
            System.out.println("Octal Number: " + Arrays.toString(nc.convertToOctal()));

        }
    }
}

