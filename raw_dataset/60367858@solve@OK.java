public void solve(int testNumber, FastReader in, PrintWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    g = new List[n];
    for (int i = 0; i < n; ++i) {
        g[i] = new ArrayList<>();
    }
    col = new int[n];
    res = new int[m];
    for (int i = 0; i < m; ++i) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        g[u].add(new int[] { v, i });
    }
    for (int i = 0; i < n; ++i) {
        if (col[i] == 0)
            dfs(i);
    }
    out.println(cycle ? 2 : 1);
    boolean first = true;
    for (int r : res) {
        if (!first)
            out.print(" ");
        first = false;
        out.print(r);
    }
    out.println();
}