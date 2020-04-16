public long[] computePowers(long p, int n, long m) {
    long[] powers = new long[n];
    powers[0] = 1;
    for (int i = 1; i < n; i++) {
        powers[i] = (powers[i - 1] * p) % m;
    }
    return powers;
}