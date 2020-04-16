public static long[] dijkstra(int s, Graph[] g) {
    long[] d = new long[g.length];
    PriorityQueue<long[]> pq = new PriorityQueue<long[]>(new Comparator<long[]>() {

        public int compare(long[] a, long[] b) {
            return Long.compare(a[1], b[1]);
        }
    });
    Arrays.fill(d, 1L << 60);
    d[s] = 0;
    pq.offer(new long[] { s, 0 });
    while (!pq.isEmpty()) {
        long[] p = pq.poll();
        int from = (int) p[0];
        if (d[from] != p[1])
            continue;
        for (int i = 0; i < g[from].size(); i++) {
            long[] e = g[from].get(i);
            int to = (int) e[0];
            if (d[to] > d[from] + e[1]) {
                d[to] = d[from] + e[1];
                pq.offer(new long[] { to, d[to] });
            }
        }
    }
    return d;
}