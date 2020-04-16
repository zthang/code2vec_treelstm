public int root(int p) {
    while (p != parent[p]) p = parent[p];
    return p;
}