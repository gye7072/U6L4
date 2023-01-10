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

    public String getConvertToDecimal(){
        int[] decimal1 = convertToDecimal();
        String decimal = "\nDecimal Number: ";
        for (int i = 0; i < decimal1.length; i++) {
            decimal += decimal1[i];
        }
        return decimal;
    }

    public String getConvertToOctal(){
        int[] octal1 = convertToOctal();
        String octal = "Octal Number: ";
        for (int i = 0; i < octal1.length; i++) {
            octal += octal1[i];
        }
        return octal;
    }

    public String getConvertToBinary(){
        int[] binary1 = convertToBinary();
        String binary = "Binary Number: ";
        for (int i = 0; i < binary1.length; i++) {
            binary += binary1[i];
        }
        return binary;
    }

    public String getConvertToHexaDecimal(){
        String[] hexa1 = convertToHexadecimal();
        String hexa = "Hexadecimal Number: ";
        for (int i = 0; i < hexa1.length; i++) {
            hexa += hexa1[i];
        }
        return hexa;
    }

    public String getConvertToAnyBase(int base){
        String[] anyBase1 = convertAnyBase(base);
        String anyBase = "Base " + base + " Number: ";
        for (int i = 0; i < anyBase1.length; i++) {
            anyBase += anyBase1[i];
        }
        return anyBase;
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

    public String[] convertAnyBase(int base){
        int count = 0;
        String originalNumberString = displayOriginalNumber().trim();
        int base10 = Integer.parseInt(originalNumberString);
        int base10V2 = base10;
        while (base10V2 > 0) {
            base10V2 = base10V2 / base;
            count++;
        }

        String[] arrayHex = new String[count];
        for(int i = 0; i < count; i++){
            arrayHex[count-(i+1)] = "" + base10 % base;
            base10 = base10 / base;
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
            if (arrayHex[i].equals("16")) {
                arrayHex[i] = "G";
            }
            if (arrayHex[i].equals("17")) {
                arrayHex[i] = "H";
            }
            if (arrayHex[i].equals("18")) {
                arrayHex[i] = "I";
            }
            if (arrayHex[i].equals("19")) {
                arrayHex[i] = "J";
            }
            if (arrayHex[i].equals("20")) {
                arrayHex[i] = "K";
            }
            if (arrayHex[i].equals("21")) {
                arrayHex[i] = "L";
            }
            if (arrayHex[i].equals("22")) {
                arrayHex[i] = "M";
            }
            if (arrayHex[i].equals("23")) {
                arrayHex[i] = "N";
            }
            if (arrayHex[i].equals("24")) {
                arrayHex[i] = "O";
            }
            if (arrayHex[i].equals("25")) {
                arrayHex[i] = "P";
            }
            if (arrayHex[i].equals("26")) {
                arrayHex[i] = "Q";
            }
            if (arrayHex[i].equals("27")) {
                arrayHex[i] = "R";
            }
            if (arrayHex[i].equals("28")) {
                arrayHex[i] = "S";
            }
            if (arrayHex[i].equals("29")) {
                arrayHex[i] = "T";
            }
            if (arrayHex[i].equals("30")) {
                arrayHex[i] = "U";
            }
            if (arrayHex[i].equals("31")) {
                arrayHex[i] = "V";
            }
            if (arrayHex[i].equals("32")) {
                arrayHex[i] = "W";
            }
            if (arrayHex[i].equals("33")) {
                arrayHex[i] = "X";
            }
            if (arrayHex[i].equals("34")) {
                arrayHex[i] = "Y";
            }
            if (arrayHex[i].equals("35")) {
                arrayHex[i] = "Z";
            }
            if (arrayHex[i].equals("36")) {
                arrayHex[i] = "a";
            }
            if (arrayHex[i].equals("37")) {
                arrayHex[i] = "b";
            }
            if (arrayHex[i].equals("38")) {
                arrayHex[i] = "c";
            }
            if (arrayHex[i].equals("39")) {
                arrayHex[i] = "d";
            }
            if (arrayHex[i].equals("40")) {
                arrayHex[i] = "e";
            }
            if (arrayHex[i].equals("41")) {
                arrayHex[i] = "f";
            }
            if (arrayHex[i].equals("42")) {
                arrayHex[i] = "g";
            }
            if (arrayHex[i].equals("43")) {
                arrayHex[i] = "h";
            }
            if (arrayHex[i].equals("44")) {
                arrayHex[i] = "i";
            }
            if (arrayHex[i].equals("45")) {
                arrayHex[i] = "j";
            }
            if (arrayHex[i].equals("46")) {
                arrayHex[i] = "k";
            }
            if (arrayHex[i].equals("47")) {
                arrayHex[i] = "l";
            }
            if (arrayHex[i].equals("48")) {
                arrayHex[i] = "m";
            }
            if (arrayHex[i].equals("49")) {
                arrayHex[i] = "n";
            }
            if (arrayHex[i].equals("50")) {
                arrayHex[i] = "o";
            }
            if (arrayHex[i].equals("51")) {
                arrayHex[i] = "p";
            }
            if (arrayHex[i].equals("52")) {
                arrayHex[i] = "q";
            }
            if (arrayHex[i].equals("53")) {
                arrayHex[i] = "r";
            }
            if (arrayHex[i].equals("54")) {
                arrayHex[i] = "s";
            }
            if (arrayHex[i].equals("55")) {
                arrayHex[i] = "t";
            }
            if (arrayHex[i].equals("56")) {
                arrayHex[i] = "u";
            }
            if (arrayHex[i].equals("57")) {
                arrayHex[i] = "v";
            }
            if (arrayHex[i].equals("58")) {
                arrayHex[i] = "w";
            }
            if (arrayHex[i].equals("59")) {
                arrayHex[i] = "x";
            }
            if (arrayHex[i].equals("60")) {
                arrayHex[i] = "y";
            }
            if (arrayHex[i].equals("61")) {
                arrayHex[i] = "z";
            }
            if (arrayHex[i].equals("62")) {
                arrayHex[i] = "+";
            }
            if (arrayHex[i].equals("63")) {
                arrayHex[i] = "/";
            }
            if (arrayHex[i].equals("64")) {
                arrayHex[i] = "F";
            }

        }
        return arrayHex;
    }
}