public static int[] BFS(ArrayList<Integer>[] adj, int v) {
    int n = adj.length;
    int[] dp = new int[n];
    Queue<Integer> q = new LinkedList<>();
    q.add(v);
    Queue<Integer> dist = new LinkedList<>();
    dist.add(0);
    HashSet<Integer> h = new HashSet<>();
    while (!q.isEmpty()) {
        int node = q.poll();
        int dd = dist.poll();
        if (h.contains(node))
            continue;
        h.add(node);
        dp[node] = dd;
        for (int u : adj[node]) {
            q.add(u);
            dist.add(dd + 1);
        }
    }
    return dp;
}