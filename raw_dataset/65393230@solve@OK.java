static void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int min1 = -1, min2 = -1;
    for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        if (min2 == -1 || a[i] < a[min2]) {
            if (min1 == -1 || a[i] <= a[min1]) {
                min2 = min1;
                min1 = i;
            } else {
                min2 = i;
            }
        }
    }
    if (m < n || n == 2) {
        out.println(-1);
        return;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
        ans += a[i] * 2;
    }
    for (int i = n; i < m; i++) {
        ans += a[min1] + a[min2];
    }
    out.println(ans);
    for (int i = 1; i < n; i++) {
        out.println(i + " " + (i + 1));
    }
    out.println(n + " " + 1);
    for (int i = n; i < m; i++) {
        out.println((min1 + 1) + " " + (min2 + 1));
    }
}