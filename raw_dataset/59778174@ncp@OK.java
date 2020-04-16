static long ncp(int k, int x) {
    if (k < x)
        return 0;
    if (k == x)
        return 1;
    long ans = 1;
    for (int i = k; i > (k - x); i--) {
        ans *= i;
        ans %= mod;
    }
    return ans;
}