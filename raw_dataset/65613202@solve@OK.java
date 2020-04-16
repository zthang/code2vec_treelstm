private static void solve(int n, int m, int[] a) throws IOException {
    if (n > m || n == 2) {
        log.write("-1\n");
        return;
    }
    int ans = 0;
    for (int x : a) {
        ans += x;
    }
    ans *= 2;
    log.write(ans + "\n");
    for (int i = 1; i < n; i++) {
        log.write(i + " " + (i + 1) + "\n");
    }
    log.write(n + " 1\n");
}