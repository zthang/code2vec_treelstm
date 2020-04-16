void solve(int TC) throws Exception {
    int n = ni(), m = ni();
    long[] d = new long[n];
    for (int i = 0; i < m; i++) {
        int x = ni() - 1, y = ni() - 1;
        long di = nl();
        d[x] -= di;
        d[y] += di;
    }
    StringBuilder ans = new StringBuilder("");
    int cnt = 0;
    int p1 = 0, p2 = 0;
    while (p1 < n && p2 < n) {
        while (p1 < n && d[p1] >= 0) p1++;
        while (p2 < n && d[p2] <= 0) p2++;
        if (p1 == n || p2 == n)
            break;
        cnt++;
        long di = Math.min(-d[p1], d[p2]);
        ans.append((1 + p1) + " " + (1 + p2) + " " + di + "\n");
        d[p1] += di;
        d[p2] -= di;
    }
    pn(cnt);
    p(ans.toString());
}