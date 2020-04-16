static long combination(long n, long r) {
    long ans = 1;
    for (long i = 0; i < r; i++) {
        ans = (ans * (n - i)) / (i + 1);
    }
    return ans;
}