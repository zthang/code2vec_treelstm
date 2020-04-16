public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    seen = new boolean[n + 1];
    g = Graph.build(in, n, m, false);
    List<Pair.IntPair> pairs = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
        if (!seen[i]) {
            int largest = dfs(i);
            pairs.add(new Pair.IntPair(i, largest));
        }
    }
    int ans = 0;
    Collections.sort(pairs);
    int end = -1, cnt = 0;
    for (Pair.IntPair p : pairs) {
        if (p.first <= end) {
            cnt++;
            end = Math.max(end, p.second);
        } else {
            if (cnt > 1)
                ans += cnt - 1;
            cnt = 1;
            end = p.second;
        }
    }
    if (cnt > 1)
        ans += cnt - 1;
    out.println(ans);
}