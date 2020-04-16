int[] nia(int start, int b) throws IOException {
    int[] a = new int[b];
    for (int i = start; i < b; i++) a[i] = ni();
    return a;
}