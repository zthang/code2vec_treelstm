private Pair<Long, Long> both(Graphs.Edge[] edges, List<Integer>[] adjLists) {
    int n = adjLists.length;
    HashSet<Integer>[] adj = new HashSet[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new HashSet<>(adjLists[i]);
    }
    int[] deg = new int[n];
    for (int i = 0; i < n; i++) {
        deg[i] = adj[i].size();
    }
    long[] wMax = new long[n];
    Arrays.fill(wMax, 1);
    long[] wMin = new long[n];
    Arrays.fill(wMin, 1);
    Queue<Integer> leaves = new ArrayDeque<>();
    BitSet visited = new BitSet(n);
    for (int i = 0; i < n; i++) {
        if (deg[i] == 1) {
            leaves.add(i);
            visited.set(i);
        }
    }
    long max = 0, min = 0;
    while (leaves.size() > 0) {
        int leaf = leaves.poll();
        if (adj[leaf].isEmpty())
            break;
        int e = adj[leaf].iterator().next();
        int parent = edges[e].i + edges[e].j - leaf;
        if (wMax[leaf] > n - wMax[leaf])
            continue;
        wMax[parent] += wMax[leaf];
        wMin[parent] ^= wMin[leaf];
        max += wMax[leaf] * edges[e].cost;
        min += wMin[leaf] * edges[e].cost;
        deg[leaf]--;
        deg[parent]--;
        adj[parent].remove(e);
        if (deg[parent] == 1 && !visited.get(parent)) {
            leaves.add(parent);
            visited.set(parent);
        }
    }
    return Pair.of(min, max);
}