private int pow(long v, int p) {
    long ans = 1;
    while (p > 0) {
        if (p % 2 == 1)
            ans = ans * v % MOD;
        v = v * v % MOD;
        p = p / 2;
    }
    return (int) ans;
}