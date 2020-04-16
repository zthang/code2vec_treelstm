public long[][] pow(long[][] x, long p) {
    if (p == 0) {
        long[][] e = new long[x.length][x.length];
        for (int i = 0; i < e.length; i++) {
            e[i][i] = 1;
        }
        return e;
    }
    long[][] ans = pow(x, p / 2);
    ans = mult(ans, ans);
    if (p % 2 == 1) {
        ans = mult(ans, x);
    }
    return ans;
}