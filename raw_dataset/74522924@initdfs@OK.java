public static void initdfs(int v, int p) {
    for (int nei : adj.get(v)) {
        if (nei == p)
            continue;
        depth[nei] = depth[v] + 1;
        lca[nei][0] = v;
        initdfs(nei, v);
    }
}