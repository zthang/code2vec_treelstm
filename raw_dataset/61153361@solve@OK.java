public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    adj = new HashSet[n + 1];
    int i, j;
    hs = new HashSet<>();
    for (i = 1; i <= n; i++) adj[i] = new HashSet<Integer>();
    for (i = 0; i < m; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        adj[a].add(b);
        adj[b].add(a);
    }
    for (i = 1; i <= 6; i++) {
        for (j = i; j <= 6; j++) {
            hs.add(new Pair(i, j));
        }
    }
    rec(0, n, "");
    out.println(max);
}