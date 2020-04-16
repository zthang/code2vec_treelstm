void union(int _a, int _b) {
    int p_a = root(_a);
    int p_b = root(_b);
    parent[p_a] = p_b;
    sz[p_b] += sz[p_a];
}