public void solve() {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int n = in.nextInt();
    int q = in.nextInt();
    pair[] edge = new pair[n - 1];
    for (int i = 0; i < n - 1; i++) {
        edge[i] = new pair(in.nextInt(), in.nextInt(), in.nextLong());
    }
    Arrays.sort(edge, new Comparator<pair>() {

        public int compare(pair p1, pair p2) {
            if (p1.z < p2.z)
                return -1;
            if (p1.z > p2.z)
                return 1;
            return 0;
        }
    });
    long[] ans = new long[q];
    query[] a = new query[q];
    for (int i = 0; i < q; i++) {
        a[i] = new query(in.nextLong(), i);
    }
    Arrays.sort(a, new Comparator<query>() {

        public int compare(query q1, query q2) {
            if (q1.x < q2.x)
                return -1;
            if (q1.x > q2.x)
                return 1;
            return 0;
        }
    });
    int idx = 0;
    long fi = 0L;
    dsu d = new dsu(n);
    for (int i = 0; i < q; i++) {
        while (idx < n - 1 && edge[idx].z.compareTo(a[i].x) <= 0) {
            long got = d.find(edge[idx].x, edge[idx].y);
            fi += got;
            d.union(edge[idx].x, edge[idx].y);
            idx++;
        }
        ans[a[i].y] = fi;
    }
    for (int i = 0; i < q; i++) {
        pw.print(ans[i] + " ");
    }
    pw.flush();
    pw.close();
}