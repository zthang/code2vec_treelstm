private SegmentTreeResult _query(int y1, int y2, int nowIndex, int leftBound, int rightBound, int tmpIncr) {
    SegmentTreeResult result = new SegmentTreeResult();
    int realLen = Math.min(y2, rightBound) - Math.max(y1, leftBound) + 1;
    if (this.isSet[nowIndex]) {
        int allIncr = tmpIncr + incrVal[nowIndex];
        result.min = setVal[nowIndex] + allIncr;
        result.max = setVal[nowIndex] + allIncr;
        result.sum = (setVal[nowIndex] + allIncr) * realLen;
        // System.out.println("isset " + nowIndex + " " + result.sum);
        return result;
    }
    if (y1 <= leftBound && y2 >= rightBound) {
        result.min = dataMin[nowIndex] + tmpIncr;
        result.max = dataMax[nowIndex] + tmpIncr;
        result.sum = dataSum[nowIndex] + tmpIncr * realLen;
        // System.out.println("cover " + nowIndex + " " + result.sum);
        return result;
    }
    int leftChild = this.getLeftChild(nowIndex);
    int rightChild = this.getRightChild(nowIndex);
    result.min = SegmentTree.INF;
    result.max = -SegmentTree.INF;
    result.sum = 0;
    int mid = leftBound + (rightBound - leftBound) / 2;
    if (y1 <= mid) {
        SegmentTreeResult leftResult = this._query(y1, y2, leftChild, leftBound, mid, tmpIncr + incrVal[nowIndex]);
        result.min = Math.min(result.min, leftResult.min);
        result.max = Math.max(result.max, leftResult.max);
        result.sum += leftResult.sum;
    }
    if (y2 > mid) {
        SegmentTreeResult rightResult = this._query(y1, y2, rightChild, mid + 1, rightBound, tmpIncr + incrVal[nowIndex]);
        result.min = Math.min(result.min, rightResult.min);
        result.max = Math.max(result.max, rightResult.max);
        result.sum += rightResult.sum;
    }
    // System.out.println("nomal " + nowIndex + " " + result.sum);
    return result;
}