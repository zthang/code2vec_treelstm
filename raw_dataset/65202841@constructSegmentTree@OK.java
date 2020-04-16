private void constructSegmentTree(int[] segmentTree, int[] input, int low, int high, int pos) {
    if (low == high) {
        segmentTree[pos] = input[low];
        return;
    }
    int mid = (low + high) / 2;
    constructSegmentTree(segmentTree, input, low, mid, 2 * pos + 1);
    constructSegmentTree(segmentTree, input, mid + 1, high, 2 * pos + 2);
    segmentTree[pos] = Math.max(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
}