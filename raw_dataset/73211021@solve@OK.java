void solve() {
    int N = ni();
    int M = ni();
    List<int[]>[] g = new List[N];
    for (int i = 0; i < N; i++) g[i] = new ArrayList<int[]>();
    for (int i = 0; i < M; i++) {
        int u = ni() - 1;
        int v = ni() - 1;
        g[u].add(new int[] { v, i });
    }
    boolean[] vn = new boolean[N];
    int[] ans = new int[M];
    for (int i = 0; i < N; i++) if (!vn[i])
        dfs(g, vn, ans, i);
    out.println(max);
    for (int i = 0; i < M; i++) {
        out.print(ans[i]);
        out.print(' ');
    }
}