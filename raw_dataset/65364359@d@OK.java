public static void d(int n, int s, int[] a, String ans) {
    if (a[0] == 1) {
        return;
    }
    if (n <= 0) {
        if (Math.sqrt(s) - (int) Math.sqrt(s) == 0) {
            a[0] = 1;
            pw.println(ans);
        }
        return;
    }
    for (int i = 1; i < 10; i++) {
        d(n - 1, s + i * i, a, ans + i);
    }
}