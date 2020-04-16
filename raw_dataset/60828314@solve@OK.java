public void solve() throws IOException {
    int n = nextInt(), m = nextInt();
    g = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        g[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int u = nextInt() - 1, v = nextInt() - 1;
        g[u].add(new Edge(v, i));
    }
    col = new int[n];
    ans = new int[m];
    one = true;
    for (int i = 0; i < n; i++) {
        if (col[i] == 0) {
            dfs(i);
        }
    }
    out.println(one ? 1 : 2);
    for (int i = 0; i < m; i++) {
        out.print(ans[i] + " ");
    }
}