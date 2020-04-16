static void DFS(int u, int pa) {
    p[id += 1] = u;
    for (int v : G[u]) if (v != pa)
        DFS(v, u);
}