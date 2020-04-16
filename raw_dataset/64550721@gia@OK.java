public int[] gia(int n, int start, int end) throws IOException {
    validate(n, start, end);
    int[] a = new int[n];
    for (int i = start; i < end; i++) {
        a[i] = ni();
    }
    return a;
}