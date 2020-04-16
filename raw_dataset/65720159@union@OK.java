public void union(int x, int y) {
    f[find(y)] = find(x);
}