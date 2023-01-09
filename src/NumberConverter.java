public class NumberConverter {
    int[] digits;
    int base;
    String[] digits2;

    public NumberConverter(String number, int base) {
        digits = new int[number.length()];
        digits2 = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String single = number.substring(i, i + 1);
            if (base != 16) {
                int d = Integer.parseInt(single);
                digits[i] = d;
            }
            digits2[i] = single;
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
                if (digits2[i].equals("A")) {
                    digits[i] = 10;
                } else if (digits2[i].equals("B")) {
                    digits[i] = 11;
                } else if (digits2[i].equals("C")) {
                    digits[i] = 12;
                } else if (digits2[i].equals("D")) {
                    digits[i] = 13;
                } else if (digits2[i].equals("E")) {
                    digits[i] = 14;
                } else if (digits2[i].equals("F")) {
                    digits[i] = 15;
                } else {
                    digits[i] = Integer.parseInt(digits2[i]);
                }
                base10[0] += digits[i] * Math.pow(16, digits.length - (1 + i));
            }
        }
        return base10;
    }


    public int[] convertToBinary() {
        String base2 = "";
        String originalNumberString = displayOriginalNumber().trim();
        int base10 = 0;
        if (base == 10) {
            base10 = Integer.parseInt(originalNumberString);
        } else if (base == 8) {
            for (int i = 0; i < digits.length; i++) {
                base10 += digits[i] * Math.pow(8, digits.length - (1 + i));
            }
        } else if (base == 16) {
            for (int i = 0; i < digits.length; i++) {
                if (digits2[i].equals("A")) {
                    digits[i] = 10;
                } else if (digits2[i].equals("B")) {
                    digits[i] = 11;
                } else if (digits2[i].equals("C")) {
                    digits[i] = 12;
                } else if (digits2[i].equals("D")) {
                    digits[i] = 13;
                } else if (digits2[i].equals("E")) {
                    digits[i] = 14;
                } else if (digits2[i].equals("F")) {
                    digits[i] = 15;
                } else {
                    digits[i] = Integer.parseInt(digits2[i]);
                }
                base10 += digits[i] * Math.pow(16, digits.length - (1 + i));
            }
        }
        while (base10 > 0) {
            base2 = base10 % 2 + base2;
            base10 = base10 / 2;
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
        int base10 = 0;
        if (base == 10) {
            base10 = Integer.parseInt(originalNumberString);
        } else if (base == 2) {
            for (int i = 0; i < digits.length; i++) {
                base10 += digits[i] * Math.pow(2, digits.length - (1 + i));
            }
        } else if (base == 16) {
            for (int i = 0; i < digits.length; i++) {
                if (digits2[i].equals("A")) {
                    digits[i] = 10;
                } else if (digits2[i].equals("B")) {
                    digits[i] = 11;
                } else if (digits2[i].equals("C")) {
                    digits[i] = 12;
                } else if (digits2[i].equals("D")) {
                    digits[i] = 13;
                } else if (digits2[i].equals("E")) {
                    digits[i] = 14;
                } else if (digits2[i].equals("F")) {
                    digits[i] = 15;
                } else {
                    digits[i] = Integer.parseInt(digits2[i]);
                }
                base10 += digits[i] * Math.pow(16, digits.length - (1 + i));
            }
        }
        while (base10 > 0) {
            base8 = base10 % 8 + base8;
            base10 = base10 / 8;
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
        int base10 = 0;
        if (base == 2) {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == 1) {
                    base10 += Math.pow(2, digits.length - (1 + i));
                }
            }
        } else if (base == 8) {
            for (int i = 0; i < digits.length; i++) {
                base10 += digits[i] * Math.pow(8, digits.length - (1 + i));
            }
        } else if (base == 10) {
            base10 = Integer.parseInt(originalNumberString);
        }
        int base10V2 = base10;
        while (base10V2 > 0) {
            base10V2 = base10V2 / 16;
            count++;
        }

        String[] arrayHex = new String[count];
            for(int i = 0; i < count; i++){
                arrayHex[count-(i+1)] = base16 + base10 % 16;
                base10 = base10 / 16;
            }

        for (int i = 0; i < count; i++) {
            if (arrayHex[i].equals("10")) {
                arrayHex[i] = "A";
            }
            if (arrayHex[i].equals("11")) {
                arrayHex[i] = "B";
            }
            if (arrayHex[i].equals("12")) {
                arrayHex[i] = "C";
            }
            if (arrayHex[i].equals("13")) {
                arrayHex[i] = "D";
            }
            if (arrayHex[i].equals("14")) {
                arrayHex[i] = "E";
            }
            if (arrayHex[i].equals("15")) {
                arrayHex[i] = "F";
            }
        }
        return arrayHex;
    }
}