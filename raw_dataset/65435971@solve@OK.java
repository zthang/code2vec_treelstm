public void solve(int testNumber, FastReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] w = new int[n];
    int min = 0;
    int sec = min;
    for (int i = 0; i < n; i++) {
        w[i] = in.nextInt();
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += w[i];
        if (w[i] < w[min]) {
            sec = min;
            min = i;
        }
    }
    if (sec == min) {
        sec = min + 1;
    }
    if (m >= n) {
        if (n == 2) {
            out.println("-1");
            return;
        }
        out.println((m - n) * (w[min] + w[sec]) + 2 * sum);
        for (int i = 1; i < n; i++) {
            out.println(i + " " + (i + 1));
        }
        out.println(n + " " + "1");
        m -= n;
        while (m > 0) {
            out.println((min + 1) + " " + (sec + 1));
            m--;
        }
    } else
        out.println("-1");
}