public static int findParent(int v) {
    if (parent[v] == v)
        return v;
    else
        return parent[v] = findParent(parent[v]);
}