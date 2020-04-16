private int[] buildDist(int start, int n, int[][] g) {
    int[] dist = new int[n];
    boolean[] used = new boolean[n];
    int[] que = new int[n];
    int quer = 0;
    int quew = 0;
    dist[start] = 0;
    used[start] = true;
    que[quew++] = start;
    while (quer < quew) {
        int u = que[quer++];
        for (int v : g[u]) {
            if (!used[v]) {
                used[v] = true;
                dist[v] = dist[u] + 1;
                que[quew++] = v;
            }
        }
    }
    return dist;
}