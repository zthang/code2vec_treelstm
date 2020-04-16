static void bfs(ArrayList<Integer> nums) {
    Queue<Integer> q = new ArrayDeque<>();
    for (int u : nums) {
        q.add(u);
        dp[u] = 0;
        vis[u] = true;
    }
    while (!q.isEmpty()) {
        int cur = q.remove();
        for (Pair p : graph[cur]) {
            if (vis[p.u])
                continue;
            vis[p.u] = true;
            dp[p.u] = dp[cur] + 1;
            q.add(p.u);
        }
    }
}