static BigInteger lcm2(long a, long b) {
    long g = gcd(a, b);
    BigInteger gg = BigInteger.valueOf(g);
    BigInteger aa = BigInteger.valueOf(a);
    BigInteger bb = BigInteger.valueOf(b);
    return aa.multiply(bb).divide(gg);
}