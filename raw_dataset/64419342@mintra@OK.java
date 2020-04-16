long[] mintra(int s) {
    long[] L = new long[size];
    for (int i = 0; i < size; i++) {
        L[i] = -1;
    }
    int[] v = new int[size];
    L[s] = s;
    PriorityQueue<Pair> Q = new PriorityQueue<Pair>(new SampleComparator().reversed());
    Q.add(new Pair(s, s));
    while (!Q.isEmpty()) {
        Pair C = Q.poll();
        if (v[(int) C.b] == 0) {
            L[(int) C.b] = C.a;
            v[(int) C.b] = 1;
            for (Edge D : list[(int) C.b]) Q.add(new Pair(Math.min(L[(int) C.b], D.cost), D.to));
        }
    }
    return L;
}