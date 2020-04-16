private int find(int q) {
    if (id[q] != q) {
        id[q] = find(id[q]);
    }
    return id[q];
}