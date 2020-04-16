boolean union(int x, int y) {
    int rx = find(x), ry = find(y);
    if (rx == ry)
        return false;
    a[rx] = ry;
    return true;
}