void dfs2(int u, int colorId, int parent) {
    for (int i = 0; i < graph[u].size(); i++) {
        int v = graph[u].get(i);
        if (v != parent) {
            dfs2(v, (colorId + 1) % 3, u);
        }
    }
    result[u] = minColorMap[colorId] + 1;
}