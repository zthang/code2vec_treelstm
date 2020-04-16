void solve() {
    int t = nextInt();
    while (t-- > 0) {
        int n = nextInt();
        int m = nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            sum += a[i];
        }
        if (n == 2)
            out.println(-1);
        else if (m < n)
            out.println(-1);
        else {
            int f = a[0], fi = 1, s = Integer.MAX_VALUE, si = -1;
            for (int i = 1; i < n; i++) {
                if (f >= a[i]) {
                    f = a[i];
                    s = f;
                    si = fi;
                    fi = i + 1;
                } else if (s > a[i]) {
                    s = a[i];
                    si = i + 1;
                }
            }
            sum = 2 * sum;
            sum += (f + s) * (m - n);
            out.println(sum);
            for (int i = 1; i < n; i++) out.println(i + " " + (i + 1));
            out.println(n + " 1");
            // now print extra
            m = m - n;
            while (m-- > 0) out.println(fi + " " + si);
        }
    }
}