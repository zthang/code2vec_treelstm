void solve() {
    int n = ni(), m = ni();
    List<Queue<Edge>> g = new ArrayList<>();
    List<Queue<Edge>> ig = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        g.add(new ArrayDeque<>());
        ig.add(new ArrayDeque<>());
    }
    for (int i = 0; i < m; i++) {
        int x = ni() - 1, y = ni() - 1, w = ni();
        Edge e = new Edge(x, y, w);
        g.get(x).add(e);
        ig.get(y).add(e);
    }
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) q.add(i);
    while (!q.isEmpty()) {
        int cur = q.poll();
        while (!g.get(cur).isEmpty() && !ig.get(cur).isEmpty()) {
            Edge ge = g.get(cur).peek();
            if (ge.f == 0) {
                g.get(cur).poll();
                continue;
            }
            Edge ige = ig.get(cur).peek();
            if (ige.f == 0) {
                ig.get(cur).poll();
                continue;
            }
            long f = Math.min(ge.f, ige.f);
            ;
            ge.f -= f;
            ige.f -= f;
            if (ige.from != ge.to) {
                Edge ne = new Edge(ige.from, ge.to, f);
                g.get(ne.from).add(ne);
                ig.get(ne.to).add(ne);
                q.add(ne.from);
                q.add(ne.to);
            }
        }
    }
    List<String> rets = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        Map<Integer, Edge> map = new HashMap<>();
        for (Edge e : g.get(i)) {
            if (e.f == 0)
                continue;
            if (map.containsKey(e.to)) {
                map.get(e.to).f += e.f;
            } else {
                map.put(e.to, e);
            }
        }
        for (int key : map.keySet()) {
            rets.add((i + 1) + " " + (key + 1) + " " + map.get(key).f);
        }
    }
    out.println(rets.size());
    for (String line : rets) {
        out.println(line);
    }
}