public static void cal_depth(int u, int p) {
    bl[0][u] = p;
    for (int v : g[u].l) {
        if (v == p)
            continue;
        d[v] = d[u] + 1;
        bl[0][v] = u;
        cal_depth(v, u);
    }
}