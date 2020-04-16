public static void division(char[] ch, int divisor) {
    int div = Character.getNumericValue(ch[0]);
    int mul = 10;
    int remainder = 0;
    StringBuilder quotient = new StringBuilder("");
    for (int i = 1; i < ch.length; i++) {
        div = div * mul + Character.getNumericValue(ch[i]);
        if (div < divisor) {
            quotient.append("0");
            continue;
        }
        quotient.append(div / divisor);
        div = div % divisor;
        mul = 10;
    }
    remainder = div;
    while (quotient.charAt(0) == '0') quotient.deleteCharAt(0);
    System.out.println(quotient + " " + remainder);
}