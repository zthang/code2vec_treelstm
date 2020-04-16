static void dfs(int u) {
    time[u] = counter++;
    for (int x : adjList[u]) {
        int v = edges[x].v;
        if (SCCnum[v] != SCCnum[u])
            continue;
        if (time[v] == -1)
            dfs(v);
    }
}