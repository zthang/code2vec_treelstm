public static void solve() {
    int n = s.nextInt();
    colors = new long[3][n];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < n; j++) {
            colors[i][j] = s.nextInt();
        }
    }
    adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new LinkedList<Integer>();
    }
    for (int i = 0; i < n - 1; i++) {
        int u = s.nextInt() - 1;
        int v = s.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    dfs(0, 0);
    if (deg1 + deg2 == n && deg1 == 2 && deg2 == n - 2 && firstdeg1 != -1) {
        arr = new int[n];
        color = new int[n];
        long ans = dfs2(firstdeg1, firstdeg1, new long[6]);
        for (int i = n - 3; i >= 0; i--) {
            color[i] = 6 - color[i + 1] - color[i + 2];
        }
        out.println(ans);
        long[] finalans = new long[n];
        for (int i = 0; i < n; i++) {
            finalans[arr[i]] = color[i];
        }
        for (int i = 0; i < n; i++) {
            out.print(finalans[i] + " ");
        }
    } else {
        out.print(-1);
        return;
    }
}