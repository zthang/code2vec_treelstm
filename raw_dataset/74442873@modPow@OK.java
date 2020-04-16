long modPow(long a, long p, long m) {
    if (a == 1)
        return 1;
    long ans = 1;
    while (p > 0) {
        if (p % 2 == 1)
            ans = (ans * a) % m;
        a = (a * a) % m;
        p >>= 1;
    }
    return ans;
}