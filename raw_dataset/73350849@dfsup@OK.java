public static void dfsup(int v, int p) {
    if (p == -1) {
        dpup[v] = 0;
    } else {
        int i = dpup[p] + dpdown[p];
        if (dpdown[v] > 0)
            i -= dpdown[v];
        dpup[v] += Math.max(i, 0);
    }
    for (int nei : adj.get(v)) {
        if (nei == p)
            continue;
        dfsup(nei, v);
    }
}