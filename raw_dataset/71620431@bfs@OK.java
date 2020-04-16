public static void bfs(int start, int[] x) {
    Arrays.fill(x, -1);
    x[start] = 0;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(start);
    while (!q.isEmpty()) {
        int p = q.poll();
        for (int i = 0; i < g[p].size(); i++) {
            int c = g[p].get(i);
            if (x[c] == -1) {
                x[c] = x[p] + 1;
                q.add(c);
            }
        }
    }
}