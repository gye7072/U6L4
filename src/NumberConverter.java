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
                int value = 0;
                if (digits[i] >= 0 && digits[i] <= 9) {
                    value = digits[i];
                } else if (digits[i] >= 10 && digits[i] <= 15) {
                    value = 10 + (digits[i] - 10);
                }
                base10[0] = (base10[0] * 16) + value;
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
            for (int i = 0; i < digits.length; i++) {
                int value = 0;
                if (digits[i] >= 0 && digits[i] <= 9) {
                    value = digits[i];
                } else if (digits[i] >= 10 && digits[i] <= 15) {
                    value = 10 + (digits[i] - 10);
                }
                String valueBinary = Integer.toBinaryString(value);
                while (valueBinary.length() < 4) {
                    valueBinary = "0" + valueBinary;
                }
                base2 += valueBinary;
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
                int value = 0;
                if (digits[i] >= 0 && digits[i] <= 9) {
                    value = digits[i];
                } else if (digits[i] >= 10 && digits[i] <= 15) {
                    value = 10 + (digits[i] - 10);
                }
                base10 += value * Math.pow(16, digits.length - (1 + i));
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


    public int[] convertToHexadecimal() {
        String hex = "";
        String originalNumberString = displayOriginalNumber().trim();
        int num = Integer.parseInt(originalNumberString);
        if(base == 2){
            num = 0;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == 1) {
                    num += Math.pow(2, digits.length - (1 + i));
                }
            }
            base = 10;
        }
        if(base == 8){
            num = 0;
            for (int i = 0; i < digits.length; i++) {
                num += digits[i] * Math.pow(8, digits.length - (1 + i));
            }
            base = 10;
        }
        if (base == 10) {
            int n = num;
            while (n > 0) {
                int remainder = n % 16;
                char c = ' ';
                if (remainder >= 0 && remainder <= 9) {
                    c = (char) ('0' + remainder);
                } else if (remainder >= 10 && remainder <= 15) {
                    c = (char) ('A' + (remainder - 10));
                }
                hex = c + hex;
                n /= 16;
            }

            int[] hexInts = new int[hex.length()];
            for (int i = 0; i < hex.length(); i++) {
                char c = hex.charAt(i);
                if (c >= '0' && c <= '9') {
                    hexInts[i] = c - '0';
                } else if (c >= 'A' && c <= 'F') {
                    hexInts[i] = 10 + (c - 'A');
                }
            }
        }
        int[] arrayHex = new int[hex.length()];
        for (int i = 0; i < hex.length(); i++) {
            arrayHex[i] = Character.getNumericValue(hex.charAt(i));
        }
        return arrayHex;
    }
}

