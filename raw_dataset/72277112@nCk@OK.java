public static long nCk(int n, int k) {
    // O(K)
    if (k > n) {
        return 0;
    }
    long res = 1;
    for (int i = 1; i <= k; i++) {
        res = ((n - k + i) * res / i) % 1000000007;
    }
    return res;
}