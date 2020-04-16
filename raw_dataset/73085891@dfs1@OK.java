static void dfs1(int n, int p) {
    for (int i = 0; i < a[n].size(); i++) {
        int idx = (int) a[n].get(i);
        if (idx == p)
            continue;
        ans[idx] = dp[idx];
        if (ans[idx] >= 0) {
            ans[idx] = Math.max(ans[n], ans[idx]);
        } else {
            ans[idx] = Math.max(ans[idx], ans[n] - 1);
        }
        dfs1(idx, n);
    }
}