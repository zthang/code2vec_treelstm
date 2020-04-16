public int[] createSegmentTree(int[] input) {
    int nextPowOfTwo = nextPowerOfTwo(input.length);
    int[] segmentTree = new int[nextPowOfTwo * 2 - 1];
    for (int i = 0; i < segmentTree.length; i++) {
        segmentTree[i] = Integer.MAX_VALUE;
    }
    constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0);
    return segmentTree;
}