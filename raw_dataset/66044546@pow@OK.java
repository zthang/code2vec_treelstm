static long pow(long a, long b, long mod) {
    long ans = 1;
    while (b > 0) {
        if (b % 2 == 1)
            ans = (ans * a) % mod;
        b = b / 2;
        a = (a * a) % mod;
    }
    return ans;
}