public void dfs(int source) {
    maxind = Math.max(maxind, source);
    visited[source] = 1;
    for (Integer num : adj[source]) {
        if (visited[num] == 0) {
            visited[num] = 1;
            dfs(num);
        }
    }
}