static void union(int a, int b) {
    a = find(a);
    b = find(b);
    int size_a = size[a];
    int size_b = size[b];
    if (a == b)
        return;
    if (rank[a] > rank[b])
        parent[b] = a;
    else if (rank[a] < rank[b])
        parent[a] = b;
    else {
        rank[b]++;
        parent[a] = b;
    }
    size[find(a)] = size_a + size_b;
}