private int[] dist(int start, int[][] g) {
    int[] dist = new int[g.length];
    Arrays.fill(dist, g.length);
    boolean[] used = new boolean[g.length];
    int[] que = new int[g.length];
    int quer = 0;
    int quew = 0;
    que[quew++] = start;
    used[start] = true;
    dist[start] = 0;
    while (quer < quew) {
        int u = que[quer++];
        for (int v : g[u]) {
            dist[v] = Math.min(dist[v], dist[u] + 1);
            if (!used[v]) {
                used[v] = true;
                que[quew++] = v;
            }
        }
    }
    return dist;
}