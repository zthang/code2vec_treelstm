public void solve(int testNumber, FastReader in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    long[] delta = new long[n];
    for (int i = 0; i < m; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        long w = in.nextLong();
        delta[u] -= w;
        delta[v] += w;
    }
    int v = 0;
    ArrayList<Integer> from = new ArrayList<>(), to = new ArrayList<>();
    ArrayList<Long> weights = new ArrayList<>();
    for (int u = 0; u < n; u++) {
        while (delta[u] < 0) {
            while (v < n && delta[v] <= 0) v++;
            if (v < n) {
                long add = Math.min(-delta[u], delta[v]);
                delta[u] += add;
                delta[v] -= add;
                from.add(u);
                to.add(v);
                weights.add(add);
            }
        }
    }
    out.println(from.size());
    for (int i = 0; i < from.size(); i++) {
        out.printf("%d %d %d\n", from.get(i) + 1, to.get(i) + 1, weights.get(i));
    }
}