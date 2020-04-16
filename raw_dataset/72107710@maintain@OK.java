private void maintain(int nowIndex, int leftBound, int rightBound) {
    int nn = rightBound - leftBound + 1;
    if (isSet[nowIndex]) {
        dataMin[nowIndex] = setVal[nowIndex] + incrVal[nowIndex];
        dataMax[nowIndex] = setVal[nowIndex] + incrVal[nowIndex];
        dataSum[nowIndex] = (setVal[nowIndex] + incrVal[nowIndex]) * nn;
        return;
    }
    if (rightBound > leftBound) {
        int leftChild = this.getLeftChild(nowIndex);
        int rightChild = this.getRightChild(nowIndex);
        dataMin[nowIndex] = Math.min(dataMin[leftChild], dataMin[rightChild]) + incrVal[nowIndex];
        dataMax[nowIndex] = Math.max(dataMax[leftChild], dataMax[rightChild]) + incrVal[nowIndex];
        dataSum[nowIndex] = dataSum[leftChild] + dataSum[rightChild] + incrVal[nowIndex] * nn;
    } else {
        // last row(range [n, 2*n-1]) has not children
        dataMin[nowIndex] = dataMax[nowIndex] = dataSum[nowIndex] = incrVal[nowIndex];
    }
}