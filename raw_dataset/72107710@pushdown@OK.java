private void pushdown(int nowIndex, int leftBound, int rightBound) {
    if (rightBound > leftBound) {
        int leftChild = this.getLeftChild(nowIndex);
        int rightChild = this.getRightChild(nowIndex);
        if (isSet[nowIndex]) {
            setVal[leftChild] = setVal[nowIndex];
            incrVal[leftChild] = incrVal[nowIndex];
            isSet[leftChild] = true;
            setVal[rightChild] = setVal[nowIndex];
            incrVal[rightChild] = incrVal[nowIndex];
            isSet[rightChild] = true;
        } else {
            incrVal[leftChild] += incrVal[nowIndex];
            incrVal[rightChild] += incrVal[nowIndex];
        }
        isSet[nowIndex] = false;
        incrVal[nowIndex] = 0;
        setVal[nowIndex] = 0;
    }
}