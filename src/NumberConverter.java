public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
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
        if(base == 2){
            for(int i = 0; i < digits.length; i++){
                if(digits[i] == 1){
                    base10[0] += Math.pow(2,digits.length-(1+i));
                }
            }
        }
        if(base == 8){
            for(int i = 0; i < digits.length; i++){
                    base10[0] += digits[i] * Math.pow(8,digits.length-(1+i));
                }
            }
        return base10;
    }

    public int[] convertToBinary() {
        int[] base2 = new int[1];
        int num = Integer.parseInt(displayOriginalNumber());
        if(base == 10){
            for(int i = 0; i < digits.length; i++){
                base2[0] += num % 2;
                num = num/2;
            }
        }
        return base2;
    }

    public int[] convertToOctal() {
        return null;
    }
}

