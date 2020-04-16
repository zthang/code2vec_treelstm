public static void dfs(int start, int[] d, int[] visited, ArrayList<Integer>[] graph, int[] a) {
    if (visited[start] == 1)
        return;
    visited[start] = 1;
    if (a[start] == 1)
        d[start] = 1;
    else
        d[start] = -1;
    for (int i = 0; i < graph[start].size(); i++) {
        int u = start;
        int v = graph[start].get(i);
        if (visited[v] == 0) {
            dfs(v, d, visited, graph, a);
            d[u] = d[u] + Math.max(d[v], 0);
        }
    }
}