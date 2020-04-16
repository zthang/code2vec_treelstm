static long gcd(long a, long b) {
    long tmp;
    while (b > 0) {
        a %= b;
        tmp = a;
        a = b;
        b = tmp;
    }
    return a;
}