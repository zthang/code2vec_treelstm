public static void dfsdown(int v, int p) {
    dpdown[v] = value[v];
    for (int nei : adj.get(v)) {
        if (nei == p)
            continue;
        dfsdown(nei, v);
        if (dpdown[nei] > 0) {
            dpdown[v] += dpdown[nei];
        }
    }
}