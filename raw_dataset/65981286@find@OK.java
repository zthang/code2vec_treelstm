public int find(int p) {
    int root = p;
    while (root != id[root]) {
        root = id[root];
    }
    while (p != root) {
        int next = id[p];
        id[p] = root;
        p = next;
    }
    return root;
}