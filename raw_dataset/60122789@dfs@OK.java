static void dfs(ArrayList<Pair>[] adj, int[] visit, int[] color, int u) {
    visit[u] = -1;
    for (Pair p : adj[u]) {
        int v = p.first;
        int i = p.second;
        if (visit[v] == -1) {
            k = 2;
            color[i] = 2;
        } else if (visit[v] == 1) {
            color[i] = 1;
        } else {
            color[i] = 1;
            dfs(adj, visit, color, v);
        }
    }
    visit[u] = 1;
}