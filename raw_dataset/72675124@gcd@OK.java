public static long gcd(long a, long b) {
    return a >= b ? gcd0(a, b) : gcd0(b, a);
}