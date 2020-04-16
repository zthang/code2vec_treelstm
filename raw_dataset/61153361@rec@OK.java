void rec(int i, int n, String x) {
    if (i == n) {
        int cur = check(x);
        // System.out.println(x + " " + cur);
        if (cur > max) {
            max = cur;
        // System.out.println(x + " " + cur);
        }
        return;
    }
    for (int j = 1; j <= 6; j++) {
        x += j + "";
        rec(i + 1, n, x);
        x = x.substring(0, x.length() - 1);
    }
}