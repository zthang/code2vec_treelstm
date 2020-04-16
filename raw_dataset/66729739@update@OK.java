void update(int ll, int rr, int time, int knight, int l, int r) {
    lazyPropagation();
    if (noIntersection(ll, rr, l, r))
        return;
    if (covered(ll, rr, l, r)) {
        setLazy(time, knight);
        return;
    }
    int mid = (l + r) / 2;
    left.update(ll, rr, time, knight, l, mid);
    right.update(ll, rr, time, knight, mid + 1, r);
}