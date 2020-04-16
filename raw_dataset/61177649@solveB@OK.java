private void solveB() throws IOException {
    int n = in.nextInt();
    long[][] M = in.nextLongTable(n, n);
    long[] a = new long[n];
    a[0] = (long) sqrt(M[0][1] * M[0][2] / M[1][2]);
    while (a[0] * a[0] < M[0][1] * M[0][2] / M[1][2]) a[0]++;
    while (a[0] * a[0] > M[0][1] * M[0][2] / M[1][2]) a[0]--;
    out.print(a[0]);
    for (int i = 1; i < n; i++) out.print(" " + M[0][i] / a[0]);
}