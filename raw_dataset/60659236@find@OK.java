int find(int p) {
    if (id[p] == p)
        return p;
    id[p] = find(id[p]);
    return id[p];
}