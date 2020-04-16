public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        sum += a[i];
    }
    if (m < n || n == 2) {
        out.println("-1");
        return;
    }
    int f = a[0], b = f;
    int ii = 0, jj = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] > f) {
            b = f;
            jj = ii;
            f = a[i];
            ii = i;
        } else if (a[i] < f && a[i] > b) {
            b = a[i];
            jj = i;
        }
    }
    int d = m - n;
    sum *= 2;
    sum += d * (f + b);
    out.println(sum);
    int i;
    for (i = 1; i < n; i++) {
        out.println(i + " " + (i + 1));
    }
    out.println(n + " " + 1);
    for (i = 0; i < d; i++) {
        out.println(ii + " " + jj);
    }
}