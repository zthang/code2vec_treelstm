static ArrayList<Point> prim() {
    ArrayList<Point> result = new ArrayList<>();
    // no.of vertices
    int n = adj.length;
    boolean[] selected = new boolean[n];
    // min_e[from].to : min w vertex connected to 'from'
    Edge[] min_e = new Edge[n];
    // which is not yet selected vertex, min_e[from].w : w of edge: from-to
    long cost = 0;
    // Arrays.fill(min_e,new Edge());//wrong because it fills it with same object
    for (int i = 0; i < n; i++) min_e[i] = new Edge();
    // for (Edge ee:min_e) System.out.println(ee.to+" "+ee.w);
    min_e[0].w = 0;
    // for (Edge ee:min_e) System.out.println(ee.to+" "+ee.w);
    for (int i = 0; i < n; i++) {
        int v = -1;
        // for (Edge ee:min_e) System.out.println(ee.to+" "+ee.w);
        for (int j = 0; j < n; j++) {
            if (!selected[j] && (v == -1 || min_e[v].w > min_e[j].w))
                v = j;
        }
        // System.out.println(v+" :V");
        cost += min_e[v].w;
        selected[v] = true;
        if (min_e[v].to != -1) {
            result.add(new Point(min_e[v].to, v));
        }
        // for (Edge ee:min_e) System.out.println(ee.to+" "+ee.w);
        for (int to = 0; to < n; to++) {
            // System.out.println(adj[v][to]+" "+min_e[to].w);
            if (adj[v][to] < min_e[to].w) {
                // System.out.println("hi");
                min_e[to].to = v;
                min_e[to].w = adj[v][to];
            // System.out.println("hi");
            }
        }
    }
    // min cost of mst
    System.out.println(cost);
    return result;
}