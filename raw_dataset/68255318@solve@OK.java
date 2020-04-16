public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt();
    a = new int[n];
    c = new int[n];
    adj = new List[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    int root = -1;
    for (int i = 0; i < n; i++) {
        int p = in.nextInt() - 1;
        c[i] = in.nextInt();
        if (p < 0) {
            root = i;
        } else {
            adj[i].add(p);
            adj[p].add(i);
        }
    }
    List<Integer> order = dfs(root, -1);
    if (order == null) {
        out.println("NO");
        return;
    }
    for (int i = 0; i < order.size(); i++) {
        a[order.get(i)] = i + 1;
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
        if (i > 0) {
            out.print(" ");
        }
        out.print(a[i]);
    }
    out.println();
}