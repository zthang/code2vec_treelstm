public long[] longArray(int n) throws IOException {
    Reader r = new Reader();
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
        arr[i] = r.nextInt();
    }
    return arr;
}