public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int t = in.scanInt();
    while (t-- > 0) {
        int n = in.scanInt();
        int m = in.scanInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.scanInt();
        long sum = 0;
        for (int k : arr) sum += (2 * k);
        if (m < n || n == 2) {
            out.println(-1);
        } else {
            int re = m - n;
            long min = Long.MAX_VALUE;
            int ii = -1;
            int jj = -1;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] + arr[j] < min) {
                        min = arr[i] + arr[j];
                        ii = i;
                        jj = j;
                    }
                }
            }
            out.println(sum + re * (min));
            for (int i = 0; i < n; i++) {
                int a = i;
                int b = (i + 1) % n;
                out.println((a + 1) + " " + (b + 1));
            }
            while (re-- > 0) {
                out.println((ii + 1) + " " + (jj + 1));
            }
        }
    }
}