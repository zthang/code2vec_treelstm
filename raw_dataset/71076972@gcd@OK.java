public long gcd(long a, long b) {
    if (a < b) {
        long c = b;
        b = a;
        a = c;
    }
    if (a % b == 0)
        return b;
    return gcd(b, a % b);
}