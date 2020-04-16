static void generate(int i) {
    if (i == 7) {
        vis = new boolean[n];
        taken = new boolean[n][n];
        cand = 0;
        for (int u = 0; u < n; u++) if (!vis[u])
            dfs(u);
        ans = Math.max(ans, cand);
        return;
    }
    for (int j = 0; j < 6; j++) {
        deg[i] = j;
        generate(i + 1);
    }
}