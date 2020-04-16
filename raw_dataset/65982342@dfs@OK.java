static void dfs(int curr, int dist) {
    if (dist > 2 || visited[curr])
        return;
    visited[curr] = true;
    for (int i = 0; i < 26; i++) {
        if (graph[curr][i])
            dfs(i, dist + 1);
    }
}