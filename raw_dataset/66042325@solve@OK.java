void solve() throws IOException {
    FastReader sc = new FastReader();
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        if (m != n) {
            System.out.println(-1);
            continue;
        }
        if (n == 2) {
            System.out.println(-1);
            continue;
        }
        long cost = 0;
        for (int i = 0; i < n; i++) {
            cost += 2 * a[i];
        }
        System.out.println(cost);
        for (int i = 0; i < n; i++) {
            int u = i;
            int v = (i + 1) % n;
            System.out.println((u + 1) + " " + (v + 1));
        }
    }
}