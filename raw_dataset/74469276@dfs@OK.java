public static void dfs(int curr, int hts, int pr) {
    tin[curr] = ++timer;
    ht[curr] = hts;
    parent[curr] = pr;
    for (Integer x : adj[curr]) {
        if (x != pr) {
            dfs(x, hts + 1, curr);
        }
    }
    tout[curr] = ++timer;
}