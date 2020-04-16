static long gcd(long g, long x) {
    if (x < 1)
        return g;
    else
        return gcd(x, g % x);
}