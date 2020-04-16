static long mod(String num, long a) {
    // Initialize result
    long res = 0;
    // One by one process all digits of 'num'
    for (int i = 0; i < num.length(); i++) res = (res * 10 + (int) num.charAt(i) - '0') % a;
    return res;
}