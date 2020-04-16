static void tarjan() {
    dfsNum = new int[V];
    dfsLow = new int[V];
    scc = new int[V];
    Arrays.fill(scc, -1);
    stack = new Stack<>();
    for (int i = 0; i < V; ++i) if (dfsNum[i] == 0)
        dfs(i);
}