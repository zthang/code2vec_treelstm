private void solveB() throws IOException {
    int n = in.nextInt();
    int[] a = in.nextIntArray(n);
    int[] st = new int[n];
    int ss = 0;
    for (int i = 0; i < n; i++) {
        while (ss > 0 && st[ss - 1] > a[i]) ss--;
        st[ss++] = a[i];
    }
    out.println(n - ss);
}