public static void solve(FastIO io) {
    int n = io.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = io.nextInt();
    int[] dist = new int[n];
    Arrays.fill(dist, -1);
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        if (i - a[i] >= 0) {
            if (a[i] % 2 != a[i - a[i]] % 2)
                dist[i] = 1;
            adj.get(i - a[i]).add(i);
        }
        if (i + a[i] < n) {
            if (a[i] % 2 != a[i + a[i]] % 2)
                dist[i] = 1;
            adj.get(i + a[i]).add(i);
        }
        if (dist[i] == 1)
            q.add(i);
    }
    while (!q.isEmpty()) {
        int u = q.remove();
        for (int v : adj.get(u)) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                q.add(v);
            }
        }
    }
    for (int i = 0; i < n; i++) io.print(dist[i] + " ");
    io.println();
}