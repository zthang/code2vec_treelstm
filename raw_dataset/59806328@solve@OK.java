public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt(), m = in.nextInt(), max = (int) 2e5 + 5;
    long[] dp = new long[max];
    DSU dsu = new DSU(n);
    ArrayList<Pair> al = new ArrayList<>();
    for (int i = 1; i < n; i++) al.add(new Pair(in.nextInt(), in.nextInt(), in.nextInt()));
    Collections.sort(al);
    for (Pair p : al) {
        dp[p.z] += (1L * dsu.size[dsu.root(p.x)] * dsu.size[dsu.root(p.y)]);
        dsu.union(p.x, p.y);
    }
    for (int i = 1; i < max; i++) dp[i] += dp[i - 1];
    while (m-- > 0) {
        out.print(dp[in.nextInt()] + " ");
    }
}