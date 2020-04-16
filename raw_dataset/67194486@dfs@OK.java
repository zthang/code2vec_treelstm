void dfs(int node, int par) {
    for (int k : g[node]) {
        if (k != par) {
            dfs(k, node);
            size[node] += size[k];
        }
    }
    size[node]++;
}