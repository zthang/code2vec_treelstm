void solve() {
    int n = scn.nextInt(), m = scn.nextInt();
    int[] from = new int[m], to = new int[m], w = new int[m];
    long[] each = new long[n];
    for (int i = 0; i < m; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
        w[i] = scn.nextInt();
        each[from[i]] -= w[i];
        each[to[i]] += w[i];
    }
    PriorityQueue<long[]> pos = new PriorityQueue<long[]>((o1, o2) -> Long.compare(o2[1], o1[1]));
    PriorityQueue<long[]> neg = new PriorityQueue<long[]>((o1, o2) -> Long.compare(o2[1], o1[1]));
    for (int i = 0; i < n; i++) {
        if (each[i] < 0) {
            neg.add(new long[] { i, -each[i] });
        } else if (each[i] > 0) {
            pos.add(new long[] { i, each[i] });
        }
    }
    ArrayList<long[]> ans = new ArrayList<>();
    while (!pos.isEmpty()) {
        long[] a = pos.poll(), b = neg.poll();
        if (a[1] > b[1]) {
            ans.add(new long[] { b[0], a[0], b[1] });
            pos.add(new long[] { a[0], a[1] - b[1] });
        } else if (b[1] > a[1]) {
            ans.add(new long[] { b[0], a[0], a[1] });
            neg.add(new long[] { b[0], b[1] - a[1] });
        } else {
            ans.add(new long[] { b[0], a[0], a[1] });
        }
    }
    out.println(ans.size());
    for (long[] a : ans) {
        out.println(++a[0] + " " + ++a[1] + " " + a[2]);
    }
}