public static int dfs(int u) {
    vis[u] = true;
    int sc = a[u];
    for (int i = 0; i < adjList[u].size(); i++) {
        int v = adjList[u].get(i);
        if (!vis[v]) {
            int x = dfs(v);
            if (x > 0) {
                sc += x;
                rootCheck[u].add(true);
            } else {
                rootCheck[u].add(false);
            }
        } else {
            rootCheck[u].add(false);
        }
    }
    return score[u] = sc;
}