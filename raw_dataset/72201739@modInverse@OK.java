private static long modInverse(long a, long m) {
    long m0 = m;
    long y = 0, x = 1;
    if (m == 1)
        return 0;
    while (a > 1) {
        long q = a / m;
        long t = m;
        m = a % m;
        a = t;
        t = y;
        y = x - q * y;
        x = t;
    }
    if (x < 0)
        x += m0;
    return x;
}