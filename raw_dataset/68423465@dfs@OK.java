static void dfs(int curr, int ex) {
    count++;
    visited[curr] = true;
    for (int next : adj[curr]) {
        if (next != ex && !visited[next]) {
            dfs(next, ex);
        }
    }
}