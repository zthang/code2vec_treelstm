private static long gcd0(long a, long b) {
    return b == 0 ? a : gcd0(b, a % b);
}