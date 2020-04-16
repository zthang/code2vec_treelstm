static void solve(FastIO io) {
    int n = io.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    int[] pwr = new int[n];
    int[] unit = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = io.nextInt();
        y[i] = io.nextInt();
    }
    for (int i = 0; i < n; i++) pwr[i] = io.nextInt();
    for (int i = 0; i < n; i++) unit[i] = io.nextInt();
    PriorityQueue<Edge> q = new PriorityQueue<>();
    DisjointSet ds = new DisjointSet(n + 1);
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (i != j)
        q.add(new Edge(i, j, (long) (unit[i] + unit[j]) * (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]))));
    for (int i = 0; i < n; i++) q.add(new Edge(i, n, pwr[i]));
    int cnt = 0;
    long total = 0;
    ArrayList<Edge> edges = new ArrayList<>();
    ArrayList<Integer> stations = new ArrayList<>();
    while (!q.isEmpty() && cnt < n) {
        Edge e = q.remove();
        if (ds.union(e.u, e.v)) {
            cnt++;
            total += e.w;
            if (e.v == n)
                stations.add(e.u);
            else if (e.u != e.v)
                edges.add(e);
        }
    }
    io.println(total);
    io.println(stations.size());
    for (int i : stations) io.print((i + 1) + " ");
    io.println();
    io.println(edges.size());
    for (Edge i : edges) io.println((i.u + 1) + " " + (i.v + 1));
}