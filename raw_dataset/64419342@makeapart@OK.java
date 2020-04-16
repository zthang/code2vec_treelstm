ArrayList<Graph> makeapart() {
    ArrayList<Graph> ans = new ArrayList<Graph>();
    boolean[] b = new boolean[size];
    int[] num = new int[size];
    for (int i = 0; i < size; i++) {
        if (b[i])
            continue;
        int sz = 0;
        ArrayList<Integer> l = new ArrayList<Integer>();
        ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
        Q.add(i);
        b[i] = true;
        while (!Q.isEmpty()) {
            int v = Q.poll();
            num[v] = sz;
            sz++;
            l.add(v);
            for (Edge e : list[v]) {
                if (!b[e.to]) {
                    Q.add(e.to);
                    b[e.to] = true;
                }
            }
        }
        Graph H = new Graph(sz);
        for (int e : l) {
            for (Edge E : list[e]) {
                H.addWeightedEdge(num[e], num[E.to], E.cost);
            }
        }
        ans.add(H);
    }
    return ans;
}