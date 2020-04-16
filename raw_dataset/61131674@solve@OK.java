public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    TaskC.Vertex[] vs = new TaskC.Vertex[n];
    for (int i = 0; i < n; ++i) vs[i] = new TaskC.Vertex(i);
    for (int i = 0; i < m; ++i) {
        TaskC.Vertex a = vs[in.nextInt() - 1];
        TaskC.Vertex b = vs[in.nextInt() - 1];
        if (a.score < b.score) {
            a.biggerNeighbors.add(b);
        } else {
            b.biggerNeighbors.add(a);
        }
        ++a.deg;
        ++b.deg;
    }
    long res = 0;
    for (TaskC.Vertex v : vs) {
        res += v.biggerNeighbors.size() * (long) (v.deg - v.biggerNeighbors.size());
    }
    out.println(res);
    int q = in.nextInt();
    for (int qi = 0; qi < q; ++qi) {
        TaskC.Vertex v = vs[in.nextInt() - 1];
        res -= v.biggerNeighbors.size() * (long) (v.deg - v.biggerNeighbors.size());
        for (TaskC.Vertex u : v.biggerNeighbors) {
            res -= u.biggerNeighbors.size() * (long) (u.deg - u.biggerNeighbors.size());
            u.biggerNeighbors.add(v);
            res += u.biggerNeighbors.size() * (long) (u.deg - u.biggerNeighbors.size());
        }
        v.biggerNeighbors.clear();
        v.score = n + qi;
        out.println(res);
    }
}