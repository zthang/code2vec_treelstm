int query(int l, int r) {
    int span = r - l + 1;
    int e = Integer.highestOneBit(span);
    int lg = Integer.numberOfTrailingZeros(e);
    return max(lift[lg][l], lift[lg][r - e + 1]);
}