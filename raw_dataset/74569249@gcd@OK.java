public long gcd(long a, long b) {
    return b == 0L ? a : gcd(b, a % b);
}