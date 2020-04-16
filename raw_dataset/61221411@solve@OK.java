public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt(), k = in.nextInt();
    DCowAndSnacks.DisjointSet ds = new DCowAndSnacks.DisjointSet(n);
    int ans = 0;
    for (int i = 0; i < k; i++) {
        int a = in.nextInt(), b = in.nextInt();
        if (!ds.isInSameSet(a, b))
            ds.union(a, b);
        else
            ans++;
    }
    out.println(ans);
    out.flush();
}