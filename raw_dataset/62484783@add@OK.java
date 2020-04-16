public void add(int x, int y) {
    nn[x].add(y);
    nn[y].add(x);
}