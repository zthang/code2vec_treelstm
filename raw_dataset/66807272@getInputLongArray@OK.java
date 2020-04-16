long[] getInputLongArray(int n) {
    long[] input = new long[n];
    for (int i = 0; i < n; i++) {
        input[i] = nextLong();
    }
    return input;
}