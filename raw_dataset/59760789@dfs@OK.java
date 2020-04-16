static void dfs(int u) {
    dfs_num[u] = dfs_low[u] = counter++;
    stack.push(u);
    for (int v : adjList[u]) {
        if (dfs_num[v] == 0)
            dfs(v);
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