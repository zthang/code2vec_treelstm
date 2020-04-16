private void solve(StandardInput reader, PrintWriter writer) throws IOException {
    int n = reader.nextInt();
    int m = reader.nextInt();
    Vertex[] vs = new Vertex[n];
    for (int i = 0; i < n; i++) vs[i] = new Vertex(i);
    for (int i = 0; i < m; i++) {
        Vertex a = vs[reader.nextInt() - 1];
        Vertex b = vs[reader.nextInt() - 1];
        if (a.sal < b.sal) {
            a.biggerNeighbours.add(b);
        } else {
            b.biggerNeighbours.add(a);
        }
        ++a.deg;
        ++b.deg;
    }
    long res = 0;
    for (Vertex v : vs) {
        res += v.biggerNeighbours.size() * (long) (v.deg - v.biggerNeighbours.size());
    }
    writer.println(res);
    int q = reader.nextInt();
    for (int i = 0; i < q; i++) {
        Vertex v = vs[reader.nextInt() - 1];
        res -= v.biggerNeighbours.size() * (long) (v.deg - v.biggerNeighbours.size());
        for (Vertex vertex : v.biggerNeighbours) {
            res -= vertex.biggerNeighbours.size() * (long) (vertex.deg - vertex.biggerNeighbours.size());
            vertex.biggerNeighbours.add(v);
            res += vertex.biggerNeighbours.size() * (long) (vertex.deg - vertex.biggerNeighbours.size());
        }
        v.biggerNeighbours.clear();
        v.sal = n + i;
        writer.println(res);
    }
}