void dfs(int src, boolean[] visited) {
    min = Math.min(src, min);
    max = Math.max(src, max);
    cnt++;
    visited[src] = true;
    for (int i = 0; i < edges[src].size(); i++) {
        int x = edges[src].get(i);
        if (!visited[x]) {
            dfs(x, visited);
        }
    }
}