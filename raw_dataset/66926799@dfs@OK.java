S dfs(int v, int p) {
    S s = new S();
    for (int[] e : g[v]) {
        if (e[0] != p) {
            S a = dfs(e[0], v);
            s.child += a.child;
            s.bestX += a.bestX;
            s.worstX += a.worstX;
            s.best += a.best + (a.bestX) * e[1];
            s.worst += a.worst + (a.worstX) * e[1];
        }
    }
    // dump(v + 1, p + 1, s.bestA, s.bestB, s.best, s.worstA, s.worstB, s.worst);
    // dump(v + 1, p + 1, s.bestX, s.best, s.worstX, s.worst);
    s.child++;
    s.bestX++;
    s.worstX++;
    {
        long matching = Math.max(0, s.worstX - (2 * n - s.child));
        s.worstX -= matching;
    }
    {
        s.bestX %= 2;
    }
    return s;
}