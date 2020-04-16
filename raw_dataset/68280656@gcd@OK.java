static BigInteger gcd(BigInteger a, BigInteger b) {
    return b.compareTo(BigInteger.ZERO) == 0 ? a : gcd(b, a.mod(b));
}