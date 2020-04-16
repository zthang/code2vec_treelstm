public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    this.out = out;
    n = in.nextInt();
    for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
    int root = -1;
    for (int i = 1; i <= n; i++) {
        int p = in.nextInt();
        c[i] = in.nextInt();
        if (p == 0)
            root = i;
        else
            tree[p].add(i);
    }
    dfs(root);
    if (!done) {
        out.println("YES");
        out.println(ans, 1, n);
    } else
        out.println("NO");
}