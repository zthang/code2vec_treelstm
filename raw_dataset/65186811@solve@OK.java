public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int m = in.scanInt();
    int[] from = new int[m];
    int[] to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = in.scanInt();
        to[i] = in.scanInt();
    }
    G = CodeHash.packGraph(from, to, n, m);
    inititalise(n);
    visited = new boolean[n + 1];
    ArrayList<int[]> pairs = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            max = Integer.MIN_VALUE;
            dfs(i, i);
            pairs.add(new int[] { i, max });
        }
    }
    int mx = 0;
    int ans = 0;
    for (int[] temp : pairs) {
        mx = Math.max(mx, temp[0]);
        while (mx <= temp[1]) {
            int findRootA = findRoot(temp[0]);
            int findRootB = findRoot(mx);
            if (findRootA != findRootB) {
                ans++;
                union(findRootA, findRootB);
            }
            mx++;
        }
    }
    out.println(ans);
}