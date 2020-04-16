static long power(long a, long b, long MOD) {
    long ans = 1;
    a = a % MOD;
    while (b != 0) {
        if (b % 2 == 1) {
            ans = (ans * a) % MOD;
        }
        a = (a * a) % MOD;
        b = b / 2;
    }
    return ans;
}