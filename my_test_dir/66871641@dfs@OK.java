static int dfs(ArrayList<Integer>[] adj, boolean[] visit, int u, int rem) {
    if (u == rem)
        return 0;
    if (visit[u])
        return 0;
    visit[u] = true;
    int ret = 1;
    for (int v : adj[u]) {
        if (!visit[v]) {
            ret += dfs(adj, visit, v, rem);
        }
    }
    return ret;
}