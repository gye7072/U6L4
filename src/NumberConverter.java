public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int[] base10 = new int[1];
        if (base == 2) {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == 1) {
                    base10[0] += Math.pow(2, digits.length - (1 + i));
                }
            }
        }
        if (base == 8) {
            for (int i = 0; i < digits.length; i++) {
                base10[0] += digits[i] * Math.pow(8, digits.length - (1 + i));
            }
        }
        if (base == 16) {
            for (int i = 0; i < digits.length; i++) {
                base10[0] += digits[i] * Math.pow(16, digits.length - (1 + i));
            }
        }
        return base10;
    }


    public int[] convertToBinary() {
        String base2 = "";
        String originalNumberString = displayOriginalNumber().trim();
        int num = Integer.parseInt(originalNumberString);
        if (base == 10) {
            while (num > 0) {
                base2 = num % 2 + base2;
                num = num / 2;
            }
        }
        if (base == 8) {
            int base10 = 0;
            for (int i = 0; i < digits.length; i++) {
                base10 += digits[i] * Math.pow(8, digits.length - (1 + i));
            }
            while (base10 > 0) {
                base2 = base10 % 2 + base2;
                base10 = base10 / 2;
            }

        }
        if(base == 16){
            int base10 = 0;
            for (int i = 0; i < digits.length; i++) {
                base10 += digits[i] * Math.pow(16, digits.length - (1 + i));
            }
            while (base10 > 0) {
                base2 = base10 % 2 + base2;
                base10 = base10 / 2;
            }

        }

        int[] arrayBase2 = new int[base2.length()];
        for (int i = 0; i < base2.length(); i++) {
            arrayBase2[i] = Character.getNumericValue(base2.charAt(i));
        }
        return arrayBase2;
    }

    public int[] convertToOctal() {
        String base8 = "";
        String originalNumberString = displayOriginalNumber().trim();
        int num = Integer.parseInt(originalNumberString);
        if (base == 10) {
            while (num > 0) {
                base8 = num % 8 + base8;
                num = num / 8;
            }
        }
        if (base == 2) {
            int base10 = 0;
            for (int i = 0; i < digits.length; i++) {
                base10 += digits[i] * Math.pow(2, digits.length - (1 + i));
            }
            while (base10 > 0) {
                base8 = base10 % 8 + base8;
                base10 = base10 / 8;
            }
        }
        if(base == 16){
            int base10 = 0;
            for (int i = 0; i < digits.length; i++) {
                base10 += digits[i] * Math.pow(8, digits.length - (1 + i));
            }
            while (base10 > 0) {
                base8 = base10 % 8 + base8;
                base10 = base10 / 8;
            }
        }
        int[] arrayBase8 = new int[base8.length()];
        for (int i = 0; i < base8.length(); i++) {
            arrayBase8[i] = Character.getNumericValue(base8.charAt(i));
        }
        return arrayBase8;
    }


    public String[] convertToHexadecimal() {
        String base16 = "";
        int count = 0;
        String originalNumberString = displayOriginalNumber().trim();
        int num = Integer.parseInt(originalNumberString);
        if(base == 2){
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == 1) {
                    num += Math.pow(2, digits.length - (1 + i));
                }
            }
            base = 10;
        }
        if(base == 8){
            for (int i = 0; i < digits.length; i++) {
                num += digits[i] * Math.pow(8, digits.length - (1 + i));
            }
            base = 10;
        }
        if (base == 10) {
            while (num > 0) {
                num = num / 16;
                count++;
            }
            num = Integer.parseInt(originalNumberString);
        }
        String[] arrayHex = new String[count];
        if(base == 10){
            int count2 = count;
            while (num > 0) {
                arrayHex[count2 - 1] = num % 16 + base16;
                num = num / 16;
                count2--;
            }

        }
        for (int i = 0; i < count; i++) {
            if(arrayHex[i].equals("10")) {
                arrayHex[i] = "A";
            }
            if(arrayHex[i].equals("11")) {
                arrayHex[i] = "B";
            }
            if(arrayHex[i].equals("12")) {
                arrayHex[i] = "C";
            }
            if(arrayHex[i].equals("13")) {
                arrayHex[i] = "D";
            }
            if(arrayHex[i].equals("14")) {
                arrayHex[i] = "E";
            }
            if(arrayHex[i].equals("15")) {
                arrayHex[i] = "F";
            }
        }

        return arrayHex;
    }
}

