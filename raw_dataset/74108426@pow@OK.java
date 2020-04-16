static long pow(long a, long b) {
    long res = 1;
    while (b > 0) {
        if ((b & 1) == 1)
            res = res * a;
        b >>= 1;
        a = a * a;
    }
    return res;
}