long gcd(long a, long b) {
    return b == 1 ? gcd(b, a % b) : a;
}