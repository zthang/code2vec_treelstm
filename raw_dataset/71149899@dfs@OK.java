static void dfs(int v, int val, int par, int no) {
    sum += c[pat[no][val]][v];
    for (int u : adj[v]) {
        if (u != par) {
            dfs(u, (val + 1) % 3, v, no);
        }
    }
}