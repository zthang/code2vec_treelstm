public void solve(int testNumber, FastReader in, PrintWriter out) {
    int n = in.nextInt();
    int K = in.nextInt();
    DJSet djSet = new DJSet(n);
    for (int i = 0; i < K; ++i) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        djSet.union(u, v);
    }
    int count = djSet.getCount();
    out.println(Math.max(K - (n - count), 0));
}