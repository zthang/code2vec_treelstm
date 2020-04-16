static void go2(int p, int at) {
    if (p != -1) {
        if (p == 0) {
            dp2[at] = dp1[p];
            if (dp1[at] > 0)
                dp2[at] -= dp1[at];
            dp2[at] = Math.max(dp2[at], 0);
        } else {
            dp2[at] = color[p] == 1 ? 1 : -1;
            dp2[at] = dp1[p] + dp2[p];
            if (dp1[at] > 0)
                dp2[at] -= dp1[at];
            dp2[at] = Math.max(dp2[at], 0);
        }
    }
    for (int i : adj[at]) {
        if (i != p)
            go2(at, i);
    }
}