void work() {
    int n = ni();
    dp = new int[n];
    color = nia(n);
    for (int i = 0; i < n; i++) {
        if (color[i] == 0)
            color[i]--;
    }
    graph = ng(n, n - 1);
    dfs1(0, new boolean[n]);
    boolean[] vis = new boolean[n];
    vis[0] = true;
    dfs2(0, vis);
    for (int r : dp) {
        out.print(r + " ");
    }
}