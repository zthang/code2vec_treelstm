int un(int i1, int i2) {
    if (i1 == -1)
        return i2;
    if (i2 == -1)
        return i1;
    return uf_rmds.union(i1, i2);
}