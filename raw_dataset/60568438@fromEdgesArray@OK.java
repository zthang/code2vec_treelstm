public static GraphLight fromEdgesArray(int V, int E, int[] u, int[] v, boolean isDirectedGraph) {
    int[] deg = new int[V];
    for (int i = 0; i < u.length; ++i) {
        deg[u[i]]++;
        if (!isDirectedGraph)
            deg[v[i]]++;
    }
    int[][] adj = new int[V][];
    for (int i = 0; i < V; ++i) adj[i] = new int[deg[i]];
    for (int i = 0; i < u.length; ++i) {
        int from = u[i];
        int to = v[i];
        adj[from][--deg[from]] = to;
        if (!isDirectedGraph)
            adj[to][--deg[to]] = from;
    }
    return new GraphLight(V, E, adj);
}