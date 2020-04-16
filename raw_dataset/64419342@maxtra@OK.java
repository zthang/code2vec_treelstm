long[] maxtra(int s, long l) {
    long[] L = new long[size];
    for (int i = 0; i < size; i++) {
        L[i] = -1;
    }
    int[] v = new int[size];
    L[s] = -1;
    PriorityQueue<Pair> Q = new PriorityQueue<Pair>(new SampleComparator());
    Q.add(new Pair(l, s));
    while (!Q.isEmpty()) {
        Pair C = Q.poll();
        if (v[(int) C.b] == 0) {
            L[(int) C.b] = C.a;
            v[(int) C.b] = 1;
            for (Edge D : list[(int) C.b]) Q.add(new Pair(Math.max(L[(int) C.b], D.cost), D.to));
        }
    }
    return L;
}