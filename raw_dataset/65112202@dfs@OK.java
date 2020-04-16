private void dfs(List<Integer>[] edges, int i, int p) {
    int u = id[i];
    for (int v : edges[u]) {
        if (v != p) {
            id[i + 1] = v;
            dfs(edges, i + 1, u);
        }
    }
}