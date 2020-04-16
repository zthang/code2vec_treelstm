public void go() throws IOException {
    ntok();
    int n = ipar();
    int m = ipar();
    Vertex[] vertices = new Vertex[n];
    for (int i = 0; i < n; i++) {
        vertices[i] = new Vertex();
    }
    int[][] edges = new int[m][2];
    for (int i = 0; i < m; i++) {
        ntok();
        edges[i][0] = ipar() - 1;
        edges[i][1] = ipar() - 1;
        vertices[edges[i][0]].others.add(vertices[edges[i][1]]);
    }
    boolean cycle = false;
    for (Vertex v : vertices) {
        if (!v.finished) {
            cycle |= dfs(v);
        }
    }
    if (cycle) {
        out.println(2);
        for (int i = 0; i < m; i++) {
            if (i != 0) {
                out.print(" ");
            }
            if (edges[i][0] < edges[i][1]) {
                out.print(1);
            } else {
                out.print(2);
            }
        }
    } else {
        out.println(1);
        for (int i = 0; i < m; i++) {
            if (i != 0) {
                out.print(" ");
            }
            out.print(1);
        }
    }
    out.println();
    out.flush();
    in.close();
}