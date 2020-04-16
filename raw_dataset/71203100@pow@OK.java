static long pow(long x, long y) {
    int p = 1000000007;
    long res = 1;
    x = x % p;
    while (y > 0) {
        if ((y & 1) == 1)
            res = (res * x) % p;
        y = y >> 1;
        x = (x * x) % p;
    }
    return res;
}