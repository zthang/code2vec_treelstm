void makeSet() {
    for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
    }
}