private static void bfs(int[] st, int v) {
    Arrays.fill(st, inf);
    Queue<Integer> q = new LinkedList<>();
    q.add(v);
    st[v] = 0;
    while (q.size() > 0) {
        int node = q.poll();
        for (int child : edges[node]) {
            if (st[child] == inf) {
                q.add(child);
                st[child] = st[node] + 1;
            }
        }
    }
}