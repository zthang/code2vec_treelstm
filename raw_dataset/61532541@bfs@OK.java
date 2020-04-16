void bfs(int nod, int c) {
    if (color[nod] != 0)
        return;
    Queue<Integer> q = new LinkedList<>();
    q.add(nod);
    vis[nod] = true;
    while (!q.isEmpty()) {
        int cur = q.poll();
        boolean can = true;
        for (int v : g[cur]) {
            if (color[v] == c) {
                can = false;
            }
            if (!vis[v]) {
                q.add(v);
                vis[v] = true;
            }
        }
        if (can) {
            color[cur] = c;
            dada[c].add(cur);
        }
    }
}