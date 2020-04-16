static void bfs(int u, boolean[] vis, HashSet<Integer>[] g, TreeSet<Integer> set) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(u);
    set.remove(u);
    while (!q.isEmpty()) {
        int p = q.poll();
        vis[p] = true;
        Integer v = set.higher(-1);
        while (v != null) {
            if (!g[p].contains(v)) {
                q.add(v);
                set.remove(v);
            }
            v = set.higher(v);
        }
    }
}