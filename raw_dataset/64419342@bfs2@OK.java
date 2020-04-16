long[] bfs2(int[] d, int s) {
    long[] L = new long[size];
    for (int i = 0; i < size; i++) {
        L[i] = -1;
    }
    int p = 0;
    L[s] = 0;
    d[s] = p;
    p++;
    ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
    Q.add(s);
    while (!Q.isEmpty()) {
        int v = Q.poll();
        for (Edge e : list[v]) {
            int w = e.to;
            long c = e.cost;
            if (L[w] == -1) {
                d[w] = p;
                p++;
                L[w] = L[v] + c;
                Q.add(w);
            }
        }
    }
    return L;
}