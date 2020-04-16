static long gcd(long a, long b) {
    if (b % a == 0)
        return a;
    return gcd(b % a, a);
}