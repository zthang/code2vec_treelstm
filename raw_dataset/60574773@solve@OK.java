void solve() {
    int n = scn.nextInt(), k = scn.nextInt();
    int[] from = new int[k], to = new int[k], w = new int[k];
    for (int i = 0; i < k; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
        w[i] = i;
    }
    int[][][] g = packWU(n, from, to, w);
    boolean[] vis = new boolean[n];
    boolean[] edg = new boolean[k];
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            vis[i] = true;
            dfs(g, vis, edg, i);
        }
    }
    int ans = 0;
    for (boolean b : edg) {
        if (!b) {
            ans++;
        }
    }
    out.println(ans);
}