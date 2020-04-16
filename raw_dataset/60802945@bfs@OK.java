long bfs(IntSet[] graph, int source, int[] W) {
    int n = graph.length;
    IntQueue queue = new IntArrayQueue();
    long[] starting = new long[n];
    for (int i = 0; i < n; i++) {
        if (i != source && graph[i].size() == 1) {
            queue.add(i);
        }
    }
    long sum = 0;
    while (!queue.isEmpty()) {
        int u = queue.poll();
        sum += W[u];
        int v = graph[u].first();
        graph[u].remove(v);
        graph[v].remove(u);
        starting[v] = Math.max(starting[v], starting[u] + W[u]);
        if (v != source && graph[v].size() == 1) {
            queue.add(v);
        }
    }
    long res = sum - ArrayUtils.maxElement(starting);
    return res;
}