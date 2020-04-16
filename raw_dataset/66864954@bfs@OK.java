static int[] bfs(int src, int tgr, int n, ArrayDeque<Integer>[] g, int clr) {
    int[] vis = new int[n + 1];
    Queue<Integer> q = new ArrayDeque<>();
    q.add(src);
    vis[src] = clr;
    vis[tgr] = clr;
    while (!q.isEmpty()) {
        int u = q.poll();
        for (int v : g[u]) {
            if (vis[v] == 0) {
                vis[v] = clr;
                q.add(v);
            }
        }
    }
    return vis;
}