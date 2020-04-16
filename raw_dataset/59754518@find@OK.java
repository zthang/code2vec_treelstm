public static int find(int v) {
    if (parent[v] == v)
        return v;
    else {
        parent[v] = find(parent[v]);
        return parent[v];
    // return find(parent[v]);
    }
}