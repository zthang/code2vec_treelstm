static long fast_exp_with_mod(long base, long exp) {
    long MOD = 1000000000 + 7;
    long res = 1;
    while (exp > 0) {
        if (exp % 2 == 1)
            res = (res * base) % MOD;
        base = (base * base) % MOD;
        exp /= 2;
    }
    return res % MOD;
}