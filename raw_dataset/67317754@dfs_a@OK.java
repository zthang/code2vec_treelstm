void dfs_a(int v, int comp) {
    used[v] = true;
    if (v != b) {
        comp_a.put(comp, comp_a.getOrDefault(comp, 0L) + 1);
        for_a[v] = comp;
    }
    for (Integer to : graph[v]) {
        if (to == a)
            continue;
        if (!used[to])
            dfs_a(to, comp);
    }
}