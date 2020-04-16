void solve() {
    int n = ni();
    int m = ni();
    path = new ArrayList[n + 1];
    dist = new Pair[n + 1];
    for (int i = 1; i <= n; i++) {
        path[i] = new ArrayList<>();
        dist[i] = new Pair(n + 1, 0);
    }
    for (int i = 0; i < m; i++) {
        int u = ni();
        int v = ni();
        path[v].add(u);
    }
    int k = ni();
    int[] a = new int[k];
    for (int i = 0; i < k; i++) {
        a[i] = ni();
    }
    bfs(a[k - 1]);
    if (!oj) {
        for (int i = 1; i <= n; i++) {
            debug(i, dist[i]);
        }
    }
    int must = 0;
    int notEqual = 0;
    for (int i = k - 1; i >= 0; i--) {
        int x = a[i];
        debug(x, dist[x], k - i - 1);
        if (dist[x].x != k - i - 1) {
            // 不是最短路
            int fa = a[i + 1];
            if (dist[fa].x + 1 == dist[x].x) {
                // 最短路 可以到下一路切换
                if (dist[x].y > 1) {
                    // 可以改变方向
                    notEqual++;
                }
            } else {
                // 最短路和上一条路不一致
                // 必需要变
                must++;
            }
        } else if (dist[x].y > 1) {
            // 多条最短路
            notEqual++;
            debug("notEqual", x);
        }
    }
    debug(must, notEqual);
    out.println(must + " " + (must + notEqual));
}