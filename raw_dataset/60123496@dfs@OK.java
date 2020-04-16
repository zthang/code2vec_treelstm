private static void dfs(int u, List<List<Integer>> links, int[][] arcs, int[] visited, int[] ans) {
    visited[u] = 1;
    for (int idx : links.get(u)) {
        int v = arcs[idx][1];
        if (visited[v] == 0) {
            ans[idx] = 1;
            dfs(v, links, arcs, visited, ans);
        } else if (visited[v] == 1) {
            ans[idx] = 2;
        } else {
            ans[idx] = 1;
        }
    }
    visited[u] = 2;
}