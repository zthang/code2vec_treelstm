public void solve(int testNumber, FastReader scan, PrintWriter out) {
    n = scan.nextInt();
    color = new int[n];
    adj = new ArrayList[n];
    dp1 = new int[n];
    dp2 = new int[n];
    for (int i = 0; i < n; i++) {
        color[i] = scan.nextInt();
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; i++) {
        int a = scan.nextInt() - 1, b = scan.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    go1(0, 0);
    go2(0, 0);
    for (int i = 0; i < n; i++) {
        out.printf("%d ", dp1[i] + dp2[i]);
    }
}