long power(long a, long b) {
    long x = 1, y = a;
    while (b > 0) {
        if (b % 2 != 0) {
            x = (x * y) % MOD;
        }
        y = (y * y) % MOD;
        b /= 2;
    }
    return x % MOD;
}