public long prefixSum(long[] fenwickTree, int index) {
    long sum = 0L;
    index += 1;
    while (index > 0) {
        sum += fenwickTree[index];
        index -= (index & (-index));
    }
    return sum;
}