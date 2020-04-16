private int find(int q) {
    if (q != id[q]) {
        id[q] = find(id[q]);
    }
    return id[q];
}