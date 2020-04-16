static int rsq(int l, int r, int[] ft) {
    return query(r, ft) - query(l - 1, ft);
}