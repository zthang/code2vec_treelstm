boolean union(int x, int y) {
    if (find(x) == find(y)) {
        return false;
    }
    int xroot = find(x);
    int yroot = find(y);
    if (xroot < yroot) {
        set[xroot] = yroot;
    } else {
        set[yroot] = xroot;
    }
    return true;
}