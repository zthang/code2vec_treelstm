public long modularExponentiation(long a, long b, long n) {
    long d = 1L;
    String bString = Long.toBinaryString(b);
    for (int i = 0; i < bString.length(); i++) {
        d = (d * d) % n;
        if (bString.charAt(i) == '1')
            d = (d * a) % n;
    }
    return d;
}