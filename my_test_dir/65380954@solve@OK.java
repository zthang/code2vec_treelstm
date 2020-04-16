public static int solve(int n, int m, int[] a) throws IOException {
    if (n == 2 || m < n)
        return -1;
    int sum = 0;
    for (int ii = 0; ii < n; ii++) sum += a[ii];
    return 2 * sum;
}