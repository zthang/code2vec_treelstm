void dfs_b(int v, int comp) {
    used[v] = true;
    if (v != a) {
        comp_b.put(comp, comp_b.getOrDefault(comp, 0L) + 1);
        for_b[v] = comp;
    }
    for (Integer to : graph[v]) {
        if (to == b)
            continue;
        if (!used[to])
            dfs_b(to, comp);
    }
}