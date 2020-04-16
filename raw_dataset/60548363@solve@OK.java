public void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    to = new ArrayList[n];
    used = new boolean[n];
    for (int i = 0; i < to.length; i++) {
        to[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        to[x].add(y);
        to[y].add(x);
    }
    int ans = 0;
    for (int i = 0; i < used.length; i++) {
        if (!used[i]) {
            ans += dfs(i) - 1;
        }
    }
    out.println(m - ans);
}