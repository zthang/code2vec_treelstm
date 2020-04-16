private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int c = 0; c < q; c++) {
        int n = in.nextInt(), m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        if (m < n) {
            out.println(-1);
        } else {
            long sum = 0;
            for (int v : a) {
                sum += v * 2;
            }
            int leftOver = m - n;
            if (leftOver == 0) {
                if (n == 2) {
                    out.println(-1);
                } else {
                    out.println(sum);
                    for (int i = 1; i < n; i++) {
                        out.println(i + " " + (i + 1));
                    }
                    out.println(n + " " + 1);
                }
            } else {
                int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
                int firstMinIdx = -1, secondMinIdx = -1;
                for (int i = 0; i < a.length; i++) {
                    if (a[i] < firstMin) {
                        secondMin = firstMin;
                        secondMinIdx = firstMinIdx;
                        firstMin = a[i];
                        firstMinIdx = i;
                    } else if (a[i] < secondMin) {
                        secondMin = a[i];
                        secondMinIdx = i;
                    }
                }
                sum += leftOver * (firstMin + secondMin);
                out.println(sum);
                for (int i = 1; i < n; i++) {
                    out.println(i + " " + (i + 1));
                }
                out.println(n + " " + 1);
                for (int i = 0; i < leftOver; i++) {
                    out.println((firstMinIdx + 1) + " " + (secondMinIdx + 1));
                }
            }
        }
    }
    out.close();
}