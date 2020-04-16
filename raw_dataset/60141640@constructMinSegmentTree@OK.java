private void constructMinSegmentTree(int[] segmentTree, int[] input, int low, int high, int pos) {
    if (low == high) {
        segmentTree[pos] = input[low];
        return;
    }
    int mid = (low + high) / 2;
    constructMinSegmentTree(segmentTree, input, low, mid, 2 * pos + 1);
    constructMinSegmentTree(segmentTree, input, mid + 1, high, 2 * pos + 2);
    segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
}