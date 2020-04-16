public static long merge(int u, int v, long res) {
    if (root(v) != root(u)) {
        int u_root = root(u);
        int v_root = root(v);
        res = res - numPairs(sz[u_root]) - numPairs(sz[v_root]);
        if (sz[u_root] < sz[v_root]) {
            id[u_root] = v_root;
            sz[v_root] += sz[u_root];
        } else {
            id[v_root] = id[u_root];
            sz[u_root] += sz[v_root];
        }
        res += numPairs(sz[root(v)]);
    }
    return res;
}