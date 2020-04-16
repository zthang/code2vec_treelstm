static boolean check() {
    vis = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        if (a[i] == 1 && vis[i] == 0) {
            cyc = 0;
            dfs(i);
            if (cyc == 1)
                return true;
        }
    }
    return false;
}