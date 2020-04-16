static long exponent(long a, long n) {
    long ans = 1;
    while (n != 0) {
        if (n % 2 == 1)
            ans = (ans * a) % mod;
        a = (a * a) % mod;
        n = n >> 1;
    }
    return ans;
}