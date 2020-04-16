public static int find(int v) {
    return (par[v] == v ? v : (par[v] = find(par[v])));
}