public static long lcm(long a, long b) {
    long ab = a * b;
    long gcd = gcd(a, b);
    return ab / gcd;
}