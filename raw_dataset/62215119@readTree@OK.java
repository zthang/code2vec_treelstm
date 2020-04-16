int[][] readTree(int n, FastScanner fs) {
    int[] deg = new int[n];
    int[] us = new int[n - 1], vs = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        us[i] = fs.nextInt() - 1;
        vs[i] = fs.nextInt() - 1;
        deg[us[i]]++;
        deg[vs[i]]++;
    }
    int[][] adj = new int[n][];
    for (int i = 0; i < n; i++) {
        adj[i] = new int[deg[i]];
        deg[i] = 0;
    }
    for (int i = 0; i < n - 1; i++) {
        int u = us[i], v = vs[i];
        adj[u][deg[u]++] = v;
        adj[v][deg[v]++] = u;
    }
    return adj;
}