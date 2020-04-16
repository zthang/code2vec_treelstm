public int[] intArray(int n) throws IOException {
    Reader r = new Reader();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = r.nextInt();
    }
    return arr;
}