public static void print(int n, int[] t, int A, int B, int C) {
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
        if (i % 3 == 0) {
            p[t[i]] = A;
        } else if (i % 3 == 1) {
            p[t[i]] = B;
        } else {
            p[t[i]] = C;
        }
    }
    for (int i = 0; i < n; i++) {
        System.out.print(p[i] + " ");
    }
    System.exit(0);
}