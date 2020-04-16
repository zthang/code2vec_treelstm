static void dfs(int u, int p) {
    L[u] = (L[p] + 1) % 3;
    for (int v : adjList[u]) if (v != p)
        dfs(v, u);
}