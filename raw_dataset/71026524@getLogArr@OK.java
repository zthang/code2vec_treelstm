private static int[] getLogArr(int n) {
    int[] arr = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
        arr[i] = (int) (Math.log(i) / Math.log(2) + 1e-10);
    }
    return arr;
}