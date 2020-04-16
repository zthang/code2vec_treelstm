static boolean[] bfs(int st) {
    boolean[] vis = new boolean[N];
    vis[st] = true;
    ArrayDeque<Integer> q = new ArrayDeque<Integer>();
    q.add(st);
    while (!q.isEmpty()) {
        int v = q.poll();
        for (Edge e : g.adj[v]) {
            if (vis[e.v] || e.v == A || e.v == B)
                continue;
            vis[e.v] = true;
            q.add(e.v);
        }
    }
    return vis;
}