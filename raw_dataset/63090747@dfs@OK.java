private boolean dfs(int node, boolean[] vis, int[] count) {
    count[0]++;
    vis[node] = true;
    for (int nn : graph[node]) {
        if (color[nn] == color[node])
            return false;
        if (!vis[nn]) {
            if (!dfs(nn, vis, count))
                return false;
        }
    }
    return true;
}