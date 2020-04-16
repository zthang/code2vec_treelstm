long gcd(long x, long y) {
    while (y > 0) {
        x = y ^ (x ^ (y = x));
        y %= x;
    }
    return x;
}