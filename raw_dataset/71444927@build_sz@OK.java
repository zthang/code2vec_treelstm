static void build_sz(int v, int pr) {
    sz[v] = 1;
    for (edge to : gr[v]) {
        if (to.to != pr && !killed[to.to]) {
            build_sz(to.to, v);
            sz[v] += sz[to.to];
        }
    }
}