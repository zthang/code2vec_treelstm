void dfs(int u, int k) {
    vis[u] = 1;
    for (int v : g[u]) {
        if (vis[v] == 0) {
            dfs(v, k);
            if (u == k) {
                // System.out.println(v+" "+size[v]);
                if (size[v] > 0)
                    size[u] += size[v];
            } else
                size[u] += size[v];
        }
    }
}