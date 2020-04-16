public void merge(int x, int y) {
    int fx = find(x);
    int fy = find(y);
    size[fy] += size[fx];
    dsu[fx] = fy;
}