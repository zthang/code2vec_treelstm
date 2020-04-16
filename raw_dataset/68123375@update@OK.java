void update(int ll, int rr, int l, int r) {
    // lazyPropagation();
    if (noIntersection(ll, rr, l, r))
        return;
    if (covered(ll, rr, l, r)) {
        // setLazy(time, knight);
        this.minIdx = -1;
        this.size = 0;
        return;
    }
    int mid = (l + r) / 2;
    left.update(ll, rr, l, mid);
    right.update(ll, rr, mid + 1, r);
    this.size = left.size + right.size;
}