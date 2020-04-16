public static long gcd(long u, long v) {
    if (u == 0)
        return v;
    return gcd(v % u, u);
}