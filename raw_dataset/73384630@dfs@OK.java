static void dfs(int[] d, int u, int v) {
    visited[u] = true;
    for (int i = 0; i < graph.get(u).size(); i++) {
        int k = graph.get(u).get(i);
        if (visited[k] == false) {
            d[u]++;
            d[k]++;
            dfs(d, graph.get(u).get(i), u);
        }
    }
}