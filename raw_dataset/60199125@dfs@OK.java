private void dfs(int node) {
    visited[node] = 1;
    for (int[] next : graph[node]) {
        int nn = next[0];
        int index = next[1];
        if (visited[nn] == 1) {
            color[index] = 2;
            ret = 2;
        } else if (visited[nn] == 0) {
            dfs(nn);
        }
    }
    visited[node] = 2;
}