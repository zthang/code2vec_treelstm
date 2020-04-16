long gcd(long a, long b) {
    while (b > 0) {
        a = b ^ (a ^ (b = a));
        b %= a;
    }
    return a;
}