public void merge(int x, int y, int[] dsu, int[] size) {
    int fx = find(x, dsu);
    int fy = find(y, dsu);
    size[fy] += size[fx];
    dsu[fx] = fy;
}