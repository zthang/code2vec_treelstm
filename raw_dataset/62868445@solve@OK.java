public void solve(InputReader in, PrintWriter out) {
    this.in = in;
    this.out = out;
    int n = in.readInt();
    int k = in.readInt();
    int c = 0;
    DSU dsu = new DSU(n + 1);
    for (int i = 0; i < k; i++) {
        if (!dsu.union(in.readInt(), in.readInt()))
            c++;
    }
    out.print(c);
}