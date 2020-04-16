public static void BFS(ArrayList<Integer>[] adj, int v) {
    Queue<Integer> q = new LinkedList<>();
    q.add(v);
    Queue<Integer> dist = new LinkedList<>();
    dist.add(0);
    HashSet<Integer> h = new HashSet<>();
    while (!q.isEmpty()) {
        int x = q.poll();
        int dd = dist.poll();
        if (h.contains(x))
            continue;
        else {
            dp[x] = dd;
            h.add(x);
            for (int u : adj[x]) {
                q.add(u);
                dist.add(dd + 1);
            }
        }
    }
}