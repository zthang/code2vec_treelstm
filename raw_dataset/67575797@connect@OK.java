void connect(int x, int y) {
    // x -> y
    int rx = find(x), ry = find(y);
    if (rx != ry) {
        a[rx] = ry;
    }
}