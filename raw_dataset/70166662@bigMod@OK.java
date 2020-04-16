private static long bigMod(long n, long k, long m) {
    long ans = 1;
    while (k > 0) {
        if ((k & 1) == 1) {
            ans = (ans * n) % m;
        }
        n = (n * n) % m;
        k >>= 1;
    }
    return ans;
}