public static void solve(int n, int m, int[] a, FastIO io) {
    if (m < n || n <= 2) {
        io.println(-1);
        return;
    }
    int[] min = new int[2];
    int[] ind = new int[2];
    long sum = 0;
    min[0] = min[1] = Integer.MAX_VALUE;
    ind[0] = ind[1] = -1;
    for (int i = 0; i < n; i++) {
        sum += a[i];
        if (a[i] < min[0]) {
            min[1] = min[0];
            min[0] = a[i];
            ind[1] = ind[0];
            ind[0] = i;
        } else if (a[i] < min[1]) {
            min[1] = a[i];
            ind[1] = i;
        }
    }
    long shift = (m - n) * (min[0] + min[1]);
    io.println(sum * 2 + shift);
    for (int i = 1; i < n; i++) {
        io.println((i) + " " + (i + 1));
    }
    io.println(1 + " " + n);
    for (int i = 0; i < m - n; i++) io.println((ind[0] + 1) + " " + (1 + ind[1]));
}