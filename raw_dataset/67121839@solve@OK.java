static void solve(FastIO io) {
    int n = io.nextInt();
    int m = io.nextInt();
    Node[] a = new Node[n];
    for (int i = 0; i < n; i++) a[i] = new Node(i);
    for (int i = 0; i < m; i++) {
        int u = io.nextInt() - 1;
        int v = io.nextInt() - 1;
        long w = io.nextLong();
        a[u].val -= w;
        a[v].val += w;
    }
    Arrays.sort(a);
    ArrayList<Edge> ans = new ArrayList<>();
    int lo = 0, hi = n - 1;
    long currLo = 0, currHi = 0;
    while (lo < hi) {
        if (currLo == 0)
            currLo = a[lo].val;
        if (currHi == 0)
            currHi = a[hi].val;
        long w = Math.min(Math.abs(currLo), Math.abs(currHi));
        if (w != 0)
            ans.add(new Edge(a[lo].id, a[hi].id, w));
        currLo += w;
        currHi -= w;
        if (currLo == 0)
            lo++;
        if (currHi == 0)
            hi--;
    }
    io.println(ans.size());
    for (Edge e : ans) io.printf("%d %d %d%n", e.u + 1, e.v + 1, e.w);
}