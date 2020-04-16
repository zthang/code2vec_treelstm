void dfs(int[][] g, int root, boolean[] visited, int[] parent, int[][] time) {
    visited[root] = true;
    time[root][0] = ct;
    ct++;
    for (int i : g[root]) {
        if (!visited[i]) {
            parent[i] = root;
            dfs(g, i, visited, parent, time);
        }
    }
    time[root][1] = ct;
    visited[root] = false;
    ct++;
}