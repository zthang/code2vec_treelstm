long dfs(int u, int colorId, int parent) {
    long sum = 0;
    for (int i = 0; i < graph[u].size(); i++) {
        int v = graph[u].get(i);
        if (v != parent) {
            sum += dfs(v, (colorId + 1) % 3, u);
        }
    }
    return sum + color[colorMap[colorId]][u];
}