int find(int a) {
    int root = a;
    while (parent[root] != root) {
        root = parent[root];
    }
    while (a != root) {
        int temp = parent[a];
        parent[a] = root;
        a = temp;
    }
    return root;
}