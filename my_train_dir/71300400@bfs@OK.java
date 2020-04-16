static void bfs(int start, int[] res) {
    for (int i = 0; i < n; i++) res[i] = inf;
    res[start] = 0;
    ArrayDeque<Integer> bfs = new ArrayDeque<>();
    bfs.add(start);
    while (!bfs.isEmpty()) {
        int v = bfs.pollFirst();
        for (int to : gr[v]) {
            if (res[to] == inf) {
                res[to] = res[v] + 1;
                bfs.add(to);
            }
        }
    }
}