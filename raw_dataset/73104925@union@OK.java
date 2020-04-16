public void union(int x, int y) {
    int xp = find(x);
    int yp = find(y);
    parent[xp] = yp;
}