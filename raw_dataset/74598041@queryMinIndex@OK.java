static int queryMinIndex(int lower, int upper, Node node) {
    if (node.lower >= lower && node.upper <= upper) {
        return node.minIndex;
    } else if (node.lower > upper || node.upper < lower) {
        return -1;
    } else {
        int leftIndex = queryMinIndex(lower, upper, node.left);
        int rightIndex = queryMinIndex(lower, upper, node.right);
        if (leftIndex == -1) {
            return rightIndex;
        }
        if (rightIndex == -1) {
            return leftIndex;
        }
        if (depth[leftIndex] <= depth[rightIndex]) {
            return leftIndex;
        } else {
            return rightIndex;
        }
    }
}