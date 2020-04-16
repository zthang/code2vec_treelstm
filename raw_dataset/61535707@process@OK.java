private int process(int u, int tag) {
    boolean[] used = new boolean[n];
    for (int i = 0; i < n; i++) {
        used[i] = i < u || disjointSet.find(i) != i;
    }
    for (int v : graph.adj(u)) {
        if (!used[v]) {
            used[v] = true;
        }
    }
    int result = 0;
    List<Integer> array = lists.get(tag);
    for (int i = 0; i < n; i++) {
        if (!used[i]) {
            result++;
            tags[i] = tag + 1;
            array.add(i);
            disjointSet.merge(i, u);
        }
    }
    return result;
}