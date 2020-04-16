void update(int i, boolean add, int l, int r) {
    if (noIntersection(i, i, l, r))
        return;
    if (covered(i, i, l, r)) {
        size = add ? 1 : 0;
        return;
    }
    int mid = (l + r) / 2;
    left.update(i, add, l, mid);
    right.update(i, add, mid + 1, r);
    size = left.size + right.size;
}