public static void process() throws IOException {
    // Your code here
    int n = ni();
    int m = ni();
    long cost = 0;
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
        A[i] = ni();
        cost += (A[i] * 2);
    }
    if (n == 2 || m < n) {
        pn("-1");
        return;
    }
    int min1 = 1000000, min2 = 1000000;
    int i1 = -1, i2 = -1;
    for (int i = 0; i < n; i++) {
        if (A[i] < min1) {
            min1 = A[i];
            i1 = i;
        }
    }
    A[i1] = 100000000;
    for (int i = 0; i < n; i++) {
        if (A[i] < min2) {
            min2 = A[i];
            i2 = i;
        }
    }
    cost += ((min1 + min2) * (m - n));
    pn(cost);
    for (int i = 1; i <= m; i++) {
        if (i < n)
            pn(i + " " + (i + 1));
        if (i == n)
            pn(n + " 1");
        if (i > n)
            pn((i1 + 1) + " " + (i2 + 1));
    }
}