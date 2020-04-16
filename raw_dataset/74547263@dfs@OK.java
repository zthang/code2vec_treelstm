static int dfs(int n, int pr, int l) {
    p[n] = pr;
    lvl[n] = lvl[pr] + 1;
    rng[n][0] = rng[n][1] = l;
    int i, j;
    for (i = 0; i < g.get(n).size(); ++i) {
        j = g.get(n).get(i);
        if (j == pr)
            continue;
        rng[n][1] = dfs(j, n, rng[n][1] + 1);
    }
    return rng[n][1];
}