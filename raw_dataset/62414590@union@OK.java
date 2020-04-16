public void union(int x, int y) {
    int px = parent[x];
    int py = parent[y];
    if (size[px] < size[py]) {
        size[py] += size[px];
        parent[px] = py;
    } else {
        size[px] += size[py];
        parent[py] = px;
    }
}