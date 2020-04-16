public void solve(FS in, PrintWriter out) {
    n = in.nextInt();
    d = new int[n];
    edges = new int[n][];
    for (int i = 0; i < n; ++i) {
        d[i] = in.nextInt();
        edges[i] = new int[] { 2 * i, 2 * i + 1, d[i] };
    }
    Arrays.sort(edges, (a, b) -> b[2] - a[2]);
    vs = new ArrayList[2 * n];
    for (int i = 0; i < 2 * n; ++i) vs[i] = new ArrayList<>();
    int r = n;
    for (int i = 0; i < n; ++i) vs[i].add(edges[i][0]);
    for (int l = 0; l < n; ++l) {
        int wanted = edges[l][2];
        int v = edges[l][1];
        while ((r - l) < wanted) ++r;
        while ((r - l) > wanted) --r;
        vs[r].add(v);
    }
    // first the line
    for (int i = 1; i < 2 * n; ++i) {
        if (vs[i].isEmpty() || vs[i - 1].isEmpty())
            continue;
        int u = vs[i - 1].get(0) + 1;
        int v = vs[i].get(0) + 1;
        out.println(u + " " + v);
    }
    // now connect with the heads to the left
    for (int i = 1; i < 2 * n; ++i) {
        if (vs[i - 1].isEmpty() || vs[i].size() <= 1)
            continue;
        int u = vs[i - 1].get(0) + 1;
        for (int j = 1; j < vs[i].size(); ++j) {
            int v = vs[i].get(j) + 1;
            out.println(u + " " + v);
        }
    }
}