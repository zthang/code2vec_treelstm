public static void dfs2(int start, int[] d, int[] visited, ArrayList<Integer>[] graph, int[] a, int[] ans, int prev) {
    if (visited[start] == 1)
        return;
    visited[start] = 1;
    ans[start] = d[start] + prev;
    for (int i = 0; i < graph[start].size(); i++) {
        int u = start;
        int v = graph[start].get(i);
        if (visited[v] == 0) {
            int exclude_u = 0;
            int include_u = ans[u] - Math.max(d[v], 0);
            dfs2(v, d, visited, graph, a, ans, Math.max(exclude_u, include_u));
        }
    }
}