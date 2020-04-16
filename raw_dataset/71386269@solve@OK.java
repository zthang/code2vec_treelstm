public void solve(int testNumber, InputReader in, PrintWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();
    g = new Set[n + 1];
    for (int i = 1; i <= n; ++i) g[i] = new HashSet<>();
    boolean[] specials = new boolean[n + 1];
    for (int i = 0; i < k; ++i) specials[in.nextInt()] = true;
    for (int i = 0; i < m; ++i) {
        int u = in.nextInt(), v = in.nextInt();
        g[u].add(v);
        g[v].add(u);
    }
    int[] dx = bfs(1);
    int[] dy = bfs(n);
    List<Pair.IntPair> ps = new ArrayList<>();
    for (int i = 1; i <= n; ++i) if (specials[i])
        ps.add(new Pair.IntPair(dx[i], dy[i]));
    ps.sort(Comparator.comparingInt(p -> p.first - p.second));
    int maxSecond = ps.get(k - 1).second;
    int minPath = 0;
    for (int i = k - 2; i >= 0; --i) {
        minPath = Math.max(minPath, ps.get(i).first + maxSecond + 1);
        maxSecond = Math.max(maxSecond, ps.get(i).second);
    }
    out.println(Math.min(dx[n], minPath));
}