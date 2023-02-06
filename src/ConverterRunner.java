import java.util.Scanner;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.println("Do you want to do basic conversion or any conversion? (Only basic or any are viable inputs)");
        Scanner s1 = new Scanner(System.in);
        String input = s1.nextLine();
        while (!input.equals("any") && !input.equals("basic")) {
            System.out.println("This is an invalid response.Please try again.\n");
            System.out.println("Do you want to do basic conversion or any conversion? (Only basic or any are viable inputs)");
            input = s1.nextLine();
        }
        if (input.equals("any")) {
            System.out.print("Enter any base 10 number: ");
            Scanner s = new Scanner(System.in);
            String number = s.nextLine();

            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                if(!((c >= '1' && c <= '9'))){
                    System.out.println("This is an invalid response. Please try again.");
                    System.out.print("Enter any base 10 number: ");
                    number = s.nextLine();
                    i = -1;
                }
            }
            System.out.print("Enter a new base(1-64) to convert to: ");
            String base = s.nextLine();

            for (int i = 0; i < base.length(); i++) {
                char c = base.charAt(i);
                if(!((c >= '1' && c <= '9'))){
                        System.out.println("This is an invalid response. Please try again.");
                        System.out.print("Enter a new base(1-64) to convert to: ");
                        base = s.nextLine();
                        i = -1;
                    }
                if((c >= '1' && c <= '9')) {
                    int base2 = Integer.parseInt(base);
                    if (!((base2 >= 1) && (base2 <= 64))) {
                        System.out.println("This is an invalid response. Please try again.");
                        System.out.print("Enter a new base(1-64) to convert to: ");
                        base = s.nextLine();
                        i = -1;
                    }
                }
            }
            int base2 = Integer.parseInt(base);

            String n = number;
            s.close();

            NumberConverter nc = new NumberConverter(n, base2);
            System.out.print(nc.getConvertToAnyBase(base2));
        }

        if (input.equals("basic")) {
            System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

            Scanner s = new Scanner(System.in);
            String choice = s.nextLine();
            while ((!choice.equals("2") && (!choice.equals("8")) && (!choice.equals("10")) && (!choice.equals("16")))) {
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
                } else if(base == 10){
                    if(!((c >= '0' && c <= '9'))){
                        System.out.println("This is an invalid response. Please try again.");
                        System.out.print("Enter your number: ");
                        number = s.nextLine();
                        i = -1;
                    }
                }else if (base == 16) {
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

            if (base == 2) {
                System.out.println(nc.getConvertToDecimal());
                System.out.println(nc.getConvertToOctal());
                System.out.println(nc.getConvertToHexaDecimal());
            }
            if (base == 8) {
                System.out.println(nc.getConvertToDecimal());
                System.out.println(nc.getConvertToBinary());
                System.out.println(nc.getConvertToHexaDecimal());
            }
            if (base == 10) {
                System.out.println(nc.getConvertToBinary());
                System.out.println(nc.getConvertToOctal());
                System.out.println(nc.getConvertToHexaDecimal());
            }
            if (base == 16) {
                System.out.println(nc.getConvertToDecimal());
                System.out.println(nc.getConvertToBinary());
                System.out.println(nc.getConvertToOctal());

            }
        }
    }
}
