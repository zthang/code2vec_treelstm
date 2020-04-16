static Pair dfs(ArrayList<Integer>[] adj, boolean[] visit, int u) {
    if (visit[u])
        return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
    visit[u] = true;
    int min = u, max = u;
    for (int v : adj[u]) {
        if (!visit[v]) {
            Pair p = dfs(adj, visit, v);
            min = Math.min(min, p.first);
            max = Math.max(max, p.second);
        }
    }
    return new Pair(min, max);
}