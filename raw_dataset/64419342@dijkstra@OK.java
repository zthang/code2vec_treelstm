long[] dijkstra(int s) {
    long[] L = new long[size];
    for (int i = 0; i < size; i++) {
        L[i] = -1;
    }
    int[] v = new int[size];
    L[s] = 0;
    PriorityQueue<LongIntPair> Q = new PriorityQueue<LongIntPair>(new LongIntSampleComparator());
    Q.add(new LongIntPair(0, s));
    while (!Q.isEmpty()) {
        LongIntPair C = Q.poll();
        if (v[C.b] == 0) {
            L[C.b] = C.a;
            v[C.b] = 1;
            for (Edge D : list[C.b]) {
                if (L[D.to] == -1 || L[D.to] > L[C.b] + D.cost) {
                    L[D.to] = L[C.b] + D.cost;
                    Q.add(new LongIntPair(L[C.b] + D.cost, D.to));
                }
            }
        }
    }
    return L;
}