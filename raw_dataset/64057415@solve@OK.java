public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    long[] x = new long[n];
    long[] y = new long[n];
    for (int i = 0; i < n; i++) {
        x[i] = in.nextInt();
        y[i] = in.nextInt();
    }
    long[] c = in.readLongArray(n);
    long[] k = in.readLongArray(n);
    List<Graphs.LEdge> edges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        edges.add(new Graphs.LEdge(i, n, c[i]));
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            long w = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
            edges.add(new Graphs.LEdge(i, j, w * (k[i] + k[j])));
        }
    }
    List<Graphs.LEdge> mst = Graphs.findMSTUsingKruskalLong(n + 1, edges);
    List<Integer> powerStations = new ArrayList<>();
    List<Graphs.LEdge> connections = new ArrayList<>();
    long answer = 0;
    for (Graphs.LEdge e : mst) {
        answer += e.cost;
        if (e.j == n) {
            powerStations.add(e.i + 1);
        } else {
            connections.add(e);
        }
    }
    out.println(answer);
    out.println(powerStations.size());
    out.println(Util.join(powerStations));
    out.println(connections.size());
    for (Graphs.LEdge e : connections) {
        out.println(Util.join(e.i + 1, e.j + 1));
    }
}