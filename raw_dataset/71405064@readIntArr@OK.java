int[] readIntArr(int n) {
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
        result[i] = Integer.parseInt(next());
    }
    return result;
}