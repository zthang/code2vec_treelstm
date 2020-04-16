public static long fastexpo(long x, long y, long p) {
    long res = 1;
    while (y > 0) {
        if ((y & 1) == 1)
            res = ((res % p) * (x % p)) % p;
        y = y >> 1;
        x = ((x % p) * (x % p)) % p;
    }
    return res;
}