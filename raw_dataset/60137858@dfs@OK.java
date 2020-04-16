void dfs(int u) {
    status[u] = 1;
    for (int v : adjList[u]) if (status[v] == 0) {
        ans[u][v] = 1;
        dfs(v);
    } else if (status[v] == 1)
        ans[u][v] = 2;
    else
        ans[u][v] = 1;
    status[u] = 2;
}