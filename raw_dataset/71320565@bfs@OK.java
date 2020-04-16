int[] bfs(int root) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(root);
    int[] res = new int[N];
    Arrays.fill(res, -1);
    res[root] = 0;
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int x : adj[cur]) {
            if (res[x] == -1) {
                res[x] = res[cur] + 1;
                q.add(x);
            }
        }
    }
    return res;
}