public void update(long[] fenwickTree, long delta, int index) {
    index += 1;
    while (index < fenwickTree.length) {
        fenwickTree[index] += delta;
        index = index + (index & (-index));
    }
}