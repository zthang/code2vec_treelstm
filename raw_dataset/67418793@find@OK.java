public int find(int i) {
    int root = i;
    while (ds[root] != root) {
        root = ds[root];
    }
    while (i != ds[i]) {
        int temp = ds[i];
        ds[i] = root;
        i = temp;
    }
    return root;
}