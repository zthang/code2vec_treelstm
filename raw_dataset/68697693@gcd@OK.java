long gcd(long a, long b) {
    return a == 0 ? b : b >= a ? gcd(b % a, a) : gcd(b, a);
}