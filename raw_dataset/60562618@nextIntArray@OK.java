int[] nextIntArray(int N) throws IOException {
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
        arr[i] = nextInt();
    }
    return arr;
}