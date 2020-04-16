static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int t = ni();
    while (t-- > 0) {
        int n = ni(), m = ni(), a = ni(), b = ni();
        ArrayList<Integer> a_edges = new ArrayList<>();
        ArrayList<Integer> b_edges = new ArrayList<>();
        ArrayList<Integer> normal_edges = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int u = ni(), v = ni();
            if (u == a || v == a) {
                if (u == a) {
                    a_edges.add(v);
                } else {
                    a_edges.add(u);
                }
            } else if (u == b || v == b) {
                if (u == b) {
                    b_edges.add(v);
                } else {
                    b_edges.add(u);
                }
            } else {
                normal_edges.add(u);
                normal_edges.add(v);
            }
        }
        int[][] cc = new int[n + 1][2];
        init(n);
        for (int i = 0; i < normal_edges.size(); i += 2) {
            un(normal_edges.get(i), normal_edges.get(i + 1));
        }
        for (int e : b_edges) {
            un(b, e);
        }
        for (int i = 1; i <= n; ++i) {
            cc[i][0] = gr(i);
        }
        init(n);
        for (int i = 0; i < normal_edges.size(); i += 2) {
            un(normal_edges.get(i), normal_edges.get(i + 1));
        }
        for (int e : a_edges) {
            if (e != b) {
                un(a, e);
            }
        }
        for (int i = 1; i <= n; ++i) {
            cc[i][1] = gr(i);
        }
        long total = 1L * (n - 2) * (n - 3);
        total /= 2;
        // pl("total : "+total);
        Map<Integer, Integer> a_freq = new HashMap<>();
        Map<Integer, Integer> b_freq = new HashMap<>();
        Map<Long, Integer> pair_freq = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            if (i == a || i == b)
                continue;
            add(a_freq, cc[i][0]);
            add(b_freq, cc[i][1]);
            long hash = 1L * cc[i][0] * (n + 1) + cc[i][1];
            add(pair_freq, hash);
        }
        for (Map.Entry<Integer, Integer> e : a_freq.entrySet()) {
            // pl("e : "+e);
            total -= C2(e.getValue());
        }
        // pl();
        for (Map.Entry<Integer, Integer> e : b_freq.entrySet()) {
            // pl("e : "+e);
            total -= C2(e.getValue());
        }
        // pl();
        for (Map.Entry<Long, Integer> e : pair_freq.entrySet()) {
            // pl("e : "+e);
            total += C2(e.getValue());
        }
        pl(total);
    }
    pw.flush();
    pw.close();
}