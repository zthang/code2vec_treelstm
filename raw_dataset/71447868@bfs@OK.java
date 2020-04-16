private static void bfs(ArrayList<ArrayList<Integer>> G, int[] d, int s) {
    Queue<Integer> q = new LinkedList<>();
    d[s] = 0;
    boolean[] vis = new boolean[G.size()];
    q.add(s);
    while (!q.isEmpty()) {
        int u = q.poll();
        if (vis[u])
            continue;
        vis[u] = true;
        for (int i = 0; i < G.get(u).size(); i++) {
            int v = G.get(u).get(i);
            if (!vis[v] && d[v] > d[u] + 1) {
                d[v] = d[u] + 1;
                q.add(v);
            }
        }
    }
}