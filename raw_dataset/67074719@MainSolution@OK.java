static void MainSolution() {
    t = ni();
    while (t-- > 0) {
        n = ni();
        m = ni();
        a = ni();
        b = ni();
        adj = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new LinkedList<>();
        vis = new int[n + 1][2];
        for (int i = 0; i < m; i++) {
            int x = ni(), y = ni();
            adj[x].add(y);
            adj[y].add(x);
        }
        dfsa(a);
        dfsb(b);
        long x = 0;
        long y = 0;
        for (int i = 1; i <= n; i++) {
            if (i == a || i == b || vis[i][0] + vis[i][1] == 2)
                continue;
            if (vis[i][0] == 1)
                x++;
            else
                y++;
        }
        if (vis[a][1] + vis[b][0] == 2)
            pl(x * y);
        else
            pl(0);
    // for (int i = 1; i <= n; i++)
    // pl(Arrays.toString(vis[i]));
    }
}