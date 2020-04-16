public void solve() {
    int n = in.nextInt();
    Coord[] coords = new Coord[n + 1];
    for (int i = 1; i <= n; i++) {
        long x = in.nextInt();
        long y = in.nextInt();
        Coord c = new Coord(x, y);
        coords[i] = c;
    }
    long[] costs = new long[n + 1];
    long[] k = new long[n + 1];
    for (int i = 1; i <= n; i++) costs[i] = in.nextInt();
    for (int i = 1; i <= n; i++) k[i] = in.nextInt();
    int[] parents = new int[n + 1];
    for (int i = 1; i <= n; i++) parents[i] = i;
    List<Edge> edges = new ArrayList<Edge>();
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            long cost = (Math.abs(coords[i].x - coords[j].x) + Math.abs(coords[i].y - coords[j].y)) * (k[i] + k[j]);
            Edge e = new Edge(cost, i, j);
            edges.add(e);
        }
    }
    for (int i = 1; i <= n; i++) {
        Edge e = new Edge(costs[i], 0, i);
        edges.add(e);
    }
    Collections.sort(edges);
    long mincost = 0;
    List<String> posts = new ArrayList();
    List<long[]> wires = new ArrayList();
    for (Edge e : edges) {
        int p1 = find(parents, e.u);
        int p2 = find(parents, e.v);
        if (p1 == p2)
            continue;
        parents[p1] = p2;
        mincost += e.cost;
        if (e.u == 0) {
            posts.add(String.valueOf(e.v));
        } else {
            wires.add(new long[] { e.u, e.v });
        }
    }
    System.out.println(mincost);
    System.out.println(posts.size());
    System.out.println(String.join(" ", posts));
    System.out.println(wires.size());
    for (int i = 0; i < wires.size(); i++) {
        long[] d = wires.get(i);
        System.out.println(d[0] + " " + d[1]);
    }
    out.flush();
}