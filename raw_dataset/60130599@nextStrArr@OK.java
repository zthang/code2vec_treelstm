String[] nextStrArr(int n) {
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
        arr[i] = next();
    }
    return arr;
}