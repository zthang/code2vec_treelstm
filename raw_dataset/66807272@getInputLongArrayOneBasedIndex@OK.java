long[] getInputLongArrayOneBasedIndex(int n) {
    long[] input = new long[n + 1];
    for (int i = 1; i <= n; i++) {
        input[i] = nextLong();
    }
    return input;
}