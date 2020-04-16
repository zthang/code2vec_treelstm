public static long pow(long n, long b, long MOD) {
    long x = 1;
    long y = n;
    while (b > 0) {
        if (b % 2 == 1) {
            x = x * y;
            if (x > MOD)
                x = x % (MOD);
        }
        y = y * y;
        if (y > MOD)
            y = y % (MOD);
        b >>= 1;
    }
    return x;
}