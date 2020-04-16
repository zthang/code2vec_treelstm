static void go_bad(int v, int pr, long ans) {
    if (!taked[v])
        ans += w[v];
    max = Math.max(max, ans);
    for (int to : gr[v]) {
        if (to != pr && bad[to])
            go_bad(to, v, ans);
    }
}