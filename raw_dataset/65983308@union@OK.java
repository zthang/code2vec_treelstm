void union(int a, int b) {
    int root_a = find(a);
    int root_b = find(b);
    if (root_a == root_b) {
        return;
    }
    if (size[root_a] < size[root_b]) {
        parent[root_a] = root_b;
        size[root_b] += size[root_a];
    } else {
        parent[root_b] = root_a;
        size[root_a] += size[root_b];
    }
}