static int root(int x) {
    if (x == parent[x])
        return x;
    else
        return parent[x] = root(parent[x]);
}