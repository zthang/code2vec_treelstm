long[] bellmanFord(int s) {
    long inf = 1000000000;
    inf *= inf;
    long[] d = new long[size];
    boolean[] n = new boolean[size];
    d[s] = 0;
    for (int i = 1; i < size; i++) {
        d[i] = inf;
        d[i] *= d[i];
    }
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size; j++) {
            for (Edge E : list[j]) {
                if (d[j] != inf && d[E.to] > d[j] + E.cost) {
                    d[E.to] = d[j] + E.cost;
                }
            }
        }
    }
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            for (Edge e : list[j]) {
                if (d[j] == inf)
                    continue;
                if (d[e.to] > d[j] + e.cost) {
                    d[e.to] = d[j] + e.cost;
                    n[e.to] = true;
                }
                if (n[j])
                    n[e.to] = true;
            }
        }
    }
    for (int i = 0; i < size; i++) {
        if (n[i])
            d[i] = inf;
    }
    return d;
}