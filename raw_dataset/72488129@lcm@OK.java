static long lcm(long c, long d) {
    return c / gcd(c, d) * d;
}