void solve() {
    int t = in.nextInt();
    for (int i = 0; i < max; i++) al[i] = new ArrayList<>();
    while (t-- > 0) {
        n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            al[i].clear();
            dp[i][0] = dp[i][1] = val[i] = 0;
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt(), b = in.nextInt();
            al[a].add(b);
            al[b].add(a);
        }
        dfs(1, 0);
        ans = 0;
        cal(1, 0);
        out.println(ans);
    }
}