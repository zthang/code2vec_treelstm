private static boolean union(int a, int b) {
    int u = find(a);
    int v = find(b);
    if (u == v)
        return false;
    else {
        par[u] = v;
        return true;
    }
}