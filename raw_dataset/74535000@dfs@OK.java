static void dfs(int a, int level) {
    if (visited[a])
        return;
    visited[a] = true;
    tin[a] = time++;
    dis[a] = level;
    for (int c : arr[a]) {
        if (!visited[c]) {
            parent[c] = a;
            dfs(c, level + 1);
        }
    }
    tout[a] = time++;
}