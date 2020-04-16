long binpowmod(long a, long n) {
    long res = 1;
    a %= mod;
    n %= mod - 1;
    while (n > 0) {
        if (n % 2 == 1)
            res = (res * a) % mod;
        a = (a * a) % mod;
        n /= 2;
    }
    return res;
}