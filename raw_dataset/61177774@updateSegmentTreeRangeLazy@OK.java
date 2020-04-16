private void updateSegmentTreeRangeLazy(int[] segmentTree, int[] lazy, int startRange, int endRange, int delta, int low, int high, int pos) {
    if (low > high) {
        return;
    }
    if (lazy[pos] != 0) {
        segmentTree[pos] += lazy[pos];
        if (low != high) {
            lazy[2 * pos + 1] += lazy[pos];
            lazy[2 * pos + 2] += lazy[pos];
        }
        lazy[pos] = 0;
    }
    if (startRange > high || endRange < low) {
        return;
    }
    if (startRange <= low && endRange >= high) {
        segmentTree[pos] += delta;
        if (low != high) {
            lazy[2 * pos + 1] += delta;
            lazy[2 * pos + 2] += delta;
        }
        return;
    }
    int mid = (low + high) / 2;
    updateSegmentTreeRangeLazy(segmentTree, lazy, startRange, endRange, delta, low, mid, 2 * pos + 1);
    updateSegmentTreeRangeLazy(segmentTree, lazy, startRange, endRange, delta, mid + 1, high, 2 * pos + 2);
    segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
}