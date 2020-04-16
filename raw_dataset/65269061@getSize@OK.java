long getSize(int s1) {
    int a = findSet(s1);
    return dsu_size[a];
}