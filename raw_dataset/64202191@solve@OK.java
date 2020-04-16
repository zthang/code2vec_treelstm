static void solve() {
    int n = in.nextInt();
    long[] x = new long[n];
    long[] y = new long[n];
    for (int i = 0; i < n; i++) {
        x[i] = in.nextLong();
        y[i] = in.nextLong();
    }
    long[] c = new long[n];
    for (int i = 0; i < n; i++) {
        c[i] = in.nextLong();
    }
    long[] k = new long[n];
    for (int i = 0; i < n; i++) {
        k[i] = in.nextLong();
    }
    LinkedList<Vertex> vs = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        vs.add(new Vertex(i, c[i]));
    }
    Collections.sort(vs, (o1, o2) -> Long.compare(o1.c, o2.c));
    LinkedList<Edge> es = new LinkedList<>();
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            long w = (k[i] + k[j]) * (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]));
            es.add(new Edge(i, j, w));
        }
    }
    Collections.sort(es, (o1, o2) -> Long.compare(o1.w, o2.w));
    ArrayList<Integer> ansV = new ArrayList<>();
    ansV.add(vs.getFirst().v);
    ArrayList<Integer> ansE = new ArrayList<>();
    long ans = vs.getFirst().c;
    DSU dsu = new DSU(n);
    for (int i = 0; i < n; i++) dsu.makeSet(i);
    boolean[] has = new boolean[n];
    has[vs.getFirst().v] = true;
    vs.pollFirst();
    while (!vs.isEmpty() || !es.isEmpty()) {
        if (!vs.isEmpty() && !es.isEmpty()) {
            Vertex v = vs.getFirst();
            Edge e = es.getFirst();
            if (v.c <= e.w) {
                int v1 = dsu.findSet(v.v);
                if (!has[v1]) {
                    has[v1] = true;
                    ans += v.c;
                    ansV.add(v.v);
                }
                vs.pollFirst();
            } else {
                int v1 = dsu.findSet(e.v);
                int v2 = dsu.findSet(e.u);
                if (v1 != v2 && (!has[v1] || !has[v2])) {
                    has[v1] = has[v1] | has[v2];
                    has[v2] = has[v1] | has[v2];
                    dsu.uniteSets(v1, v2);
                    ans += e.w;
                    ansE.add(e.v);
                    ansE.add(e.u);
                }
                es.pollFirst();
            }
        } else if (!vs.isEmpty()) {
            Vertex v = vs.getFirst();
            if (!has[dsu.findSet(v.v)]) {
                has[dsu.findSet(v.v)] = true;
                ans += v.c;
            }
            vs.pollFirst();
        } else if (!es.isEmpty()) {
            Edge e = es.getFirst();
            int v1 = dsu.findSet(e.v);
            int v2 = dsu.findSet(e.u);
            if (v1 != v2 && (!has[v1] || !has[v2])) {
                has[v1] = has[v1] | has[v2];
                has[v2] = has[v1] | has[v2];
                dsu.uniteSets(v1, v2);
                ans += e.w;
                ansE.add(e.v);
                ansE.add(e.u);
            }
            es.pollFirst();
        }
    }
    out.println(ans);
    out.println(ansV.size());
    for (int i = 0; i < ansV.size(); i++) {
        out.print((ansV.get(i) + 1) + " ");
    }
    out.println();
    out.println(ansE.size() / 2);
    for (int i = 0; i < ansE.size(); i += 2) {
        out.println((ansE.get(i) + 1) + " " + (ansE.get(i + 1) + 1));
    }
}