public static void dfs(int v, int p) {
    visited[v] = true;
    for (int item : adj[v]) if (visited[item]) {
        if (item != p)
            mark[v] = true;
    } else {
        dfs(item, v);
        if (mark[item])
            mark[v] = mark[v] | mark[item];
        else
            attach[v] = Math.max(attach[v], attach[item]);
    }
    if (!mark[v])
        attach[v] += wt[v];
}