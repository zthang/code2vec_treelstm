static long mod_pow(long k, long n, long p) {
    long res = 1L;
    long temp = k;
    while (n != 0L) {
        if ((n & 1L) == 1L) {
            res = (res * temp) % p;
        }
        temp = (temp * temp) % p;
        n = n >> 1L;
    }
    return res % p;
}