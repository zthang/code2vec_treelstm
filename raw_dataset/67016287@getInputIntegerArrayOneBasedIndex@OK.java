int[] getInputIntegerArrayOneBasedIndex(int n) {
    int[] input = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        input[i] = nextInt();
    }
    return input;
}