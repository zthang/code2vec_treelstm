static void tarjanSCC(int u) {
    dfs_num[u] = dfs_low[u] = ++counter;
    stack.push(u);
    for (int x : adjList[u]) {
        int v = edges[x].v;
        if (dfs_num[v] == 0)
            tarjanSCC(v);
        if (SCCnum[v] == -1)
            dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
    }
    if (dfs_num[u] == dfs_low[u]) {
        while (true) {
            int v = stack.pop();
            SCCnum[v] = SCC;
            if (v == u)
                break;
        }
        SCC++;
    }
}