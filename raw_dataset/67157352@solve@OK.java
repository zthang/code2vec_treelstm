public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] bal = new long[n + 1];
    for (int i = 0; i < m; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
        long cost = in.nextLong();
        bal[x] += cost;
        bal[y] -= cost;
    }
    int v = 1;
    ArrayList<Triple> result = new ArrayList<Triple>();
    for (int u = 1; u <= n; u++) {
        if (bal[u] == 0)
            continue;
        while (bal[u] > 0) {
            while (v <= n && bal[v] >= 0) v += 1;
            long cost = Math.min(bal[u], -bal[v]);
            bal[u] -= cost;
            bal[v] += cost;
            result.add(new Triple(u, v, cost));
        }
    }
    out.println(result.size());
    for (int i = 0; i < result.size(); i++) {
        out.println(result.get(i).u + " " + result.get(i).v + " " + result.get(i).cost);
    }
}