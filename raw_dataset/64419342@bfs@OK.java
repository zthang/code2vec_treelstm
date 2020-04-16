long[][] bfs(int s) {
    long[][] L = new long[2][size];
    for (int i = 0; i < size; i++) {
        L[0][i] = -1;
        L[1][i] = -1;
    }
    L[0][s] = 0;
    ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
    Q.add(s);
    while (!Q.isEmpty()) {
        int v = Q.poll();
        for (Edge e : list[v]) {
            int w = e.to;
            long c = e.cost;
            if (L[0][w] == -1) {
                L[0][w] = L[0][v] + c;
                L[1][w] = v;
                Q.add(w);
            }
        }
    }
    return L;
}