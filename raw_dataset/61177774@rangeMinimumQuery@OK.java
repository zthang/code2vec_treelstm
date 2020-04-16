private int rangeMinimumQuery(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos) {
    if (qlow <= low && qhigh >= high) {
        return segmentTree[pos];
    }
    if (qlow > high || qhigh < low) {
        return Integer.MIN_VALUE;
    }
    int mid = (low + high) / 2;
    return Math.max(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1), rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2));
}