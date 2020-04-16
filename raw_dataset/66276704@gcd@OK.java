public long gcd(long a, long b) {
    if (a < b) {
        k = a;
        a = b;
        b = k;
    }
    while (b != 0) {
        a %= b;
        k = a;
        a = b;
        b = k;
    }
    return a;
}