long gcd(long x, long y) {
    return x == 0 ? y : gcd(y % x, x);
}