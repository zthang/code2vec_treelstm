static long repow(long b, long p, long modder) {
    long a = b % modder;
    long res = 1;
    while (p > 0) {
        if (p % 2 == 1) {
            res = (res * a) % modder;
        }
        a = (a * a) % modder;
        p /= 2;
    }
    return res;
}