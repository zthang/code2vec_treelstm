public void solve(int testNumber, FastInput in, PrintWriter out) {
    setParr();
    int n = in.ni(), m = in.ni();
    ArrayList<Pair> list = new ArrayList<>();
    for (int i = 0; i < n - 1; ++i) {
        list.add(new Pair(in.ni(), in.ni(), in.ni()));
    }
    list.sort(new Comparator<Pair>() {

        public int compare(Pair p1, Pair p2) {
            return p1.c - p2.c;
        }
    });
    ArrayList<Pair> query = new ArrayList<>();
    for (int i = 0; i < m; ++i) {
        query.add(new Pair(in.ni(), i, 0));
    }
    query.sort(new Comparator<Pair>() {

        public int compare(Pair pair, Pair t1) {
            return pair.a - t1.a;
        }
    });
    int idx = 0;
    long[] fans = new long[m];
    for (int i = 0; i < m; ++i) {
        while (idx < n - 1 && query.get(i).a >= list.get(idx).c) {
            merge(list.get(idx).a, list.get(idx).b);
            ++idx;
        // out.println(idx);
        }
        // out.println(query.get(i).b+" "+ans+" -- "+idx);
        fans[query.get(i).b] = ans;
    }
    for (int i = 0; i < m; i++) {
        out.print(fans[i] + " ");
    }
    out.println();
}