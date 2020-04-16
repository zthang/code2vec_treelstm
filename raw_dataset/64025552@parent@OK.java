static int parent(int a) {
    if (uf[a] == a)
        return a;
    uf[a] = parent(uf[a]);
    return uf[a];
}