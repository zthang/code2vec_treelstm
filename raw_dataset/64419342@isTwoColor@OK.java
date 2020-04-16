int[] isTwoColor() {
    int[] L = new int[size];
    for (int i = 0; i < size; i++) {
        L[i] = -1;
    }
    L[0] = 0;
    ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
    Q.add(0);
    while (!Q.isEmpty()) {
        int v = Q.poll();
        for (Edge e : list[v]) {
            int w = e.to;
            if (L[w] == -1) {
                L[w] = 1 - L[v];
                Q.add(w);
            } else {
                if (L[v] + L[w] != 1) {
                    L[0] = -2;
                }
            }
        }
    }
    return L;
}