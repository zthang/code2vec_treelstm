private ArrayList<long[]>[] ngw(int n, int m) {
    ArrayList<long[]>[] graph = (ArrayList<long[]>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int i = 1; i <= m; i++) {
        long s = in.nextLong() - 1, e = in.nextLong() - 1, w = in.nextLong();
        graph[(int) s].add(new long[] { e, w, i });
        graph[(int) e].add(new long[] { s, w });
    }
    return graph;
}