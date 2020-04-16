static long power(long n, long m) {
    if (m == 0)
        return 1;
    long ans = 1;
    while (m > 0) {
        ans = ans * n;
        m--;
    }
    return ans;
}