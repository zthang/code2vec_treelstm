private int rangeMinimumQueryLazy(int[] segmentTree, int[] lazy, int qlow, int qhigh, int low, int high, int pos) {
    if (low > high) {
        return Integer.MAX_VALUE;
    }
    if (lazy[pos] != 0) {
        segmentTree[pos] += lazy[pos];
        if (low != high) {
            lazy[2 * pos + 1] += lazy[pos];
            lazy[2 * pos + 2] += lazy[pos];
        }
        lazy[pos] = 0;
    }
    if (qlow > high || qhigh < low) {
        return Integer.MAX_VALUE;
    }
    if (qlow <= low && qhigh >= high) {
        return segmentTree[pos];
    }
    int mid = (low + high) / 2;
    return Math.min(rangeMinimumQueryLazy(segmentTree, lazy, qlow, qhigh, low, mid, 2 * pos + 1), rangeMinimumQueryLazy(segmentTree, lazy, qlow, qhigh, mid + 1, high, 2 * pos + 2));
}