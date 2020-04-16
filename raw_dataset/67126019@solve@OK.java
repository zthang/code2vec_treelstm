public void solve() {
    int n = in.ni(), m = in.ni();
    long[] W = new long[n + 1];
    for (int i = 0; i < m; ++i) {
        int u = in.ni(), v = in.ni();
        long w = in.nl();
        W[u] += w;
        W[v] -= w;
    }
    ArrayList<Pair> ans = new ArrayList<>();
    int j = 0;
    for (int i = 0; i <= n; ) {
        while (i <= n && W[i] <= 0) i++;
        while (j <= n && W[j] >= 0) j++;
        if (i > n || j > n)
            break;
        long temp = Math.min(W[i], -1L * W[j]);
        ans.add(new Pair(i, j, temp));
        W[j] += temp;
        W[i] -= temp;
    }
    out.println(ans.size());
    for (int k = 0; k < ans.size(); ++k) {
        out.println(ans.get(k).u + " " + ans.get(k).v + " " + ans.get(k).w);
    }
}