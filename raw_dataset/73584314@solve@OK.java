public void solve() {
    n = in.ni();
    color = new int[n];
    for (int i = 0; i < n; i++) {
        color[i] = in.ni();
        if (color[i] == 0) {
            color[i]--;
        }
    }
    for (int i = 0; i < n; i++) {
        tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
        int u = in.ni() - 1, v = in.ni() - 1;
        tree.get(u).add(v);
        tree.get(v).add(u);
    }
    dp = new int[n];
    ans = new int[n];
    dfs(0, -1);
    dfs2(0, -1);
    for (int i = 0; i < n; i++) {
        out.print(ans[i]);
        out.print(' ');
    }
}