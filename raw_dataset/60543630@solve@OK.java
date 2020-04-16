public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    g = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        g[i] = new ArrayList<>();
    }
    for (int i = 0; i < k; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        g[x].add(y);
        g[y].add(x);
    }
    int nc = 0;
    u = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!u[i]) {
            dfs(i);
            nc++;
        }
    }
    out.println(k - (n - nc));
}