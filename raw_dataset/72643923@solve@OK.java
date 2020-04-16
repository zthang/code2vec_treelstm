void solve() {
    int tc = in.nextInt();
    Random rnd = new Random(System.currentTimeMillis() * 787788);
    for (int t = 0; t < tc; t++) {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] ci = new long[n];
        for (int i = 0; i < n; i++) {
            ci[i] = in.nextLong();
        }
        long[] colorLeft = new long[n];
        for (int i = 0; i < n; i++) {
            colorLeft[i] = rnd.nextLong();
        }
        long[] colorRight = new long[n];
        for (int i = 0; i < m; i++) {
            int left = in.nextInt() - 1;
            colorRight[in.nextInt() - 1] ^= colorLeft[left];
        }
        O[] a = new O[n];
        for (int i = 0; i < n; i++) {
            a[i] = new O(i, colorRight[i]);
        }
        Arrays.sort(a);
        long res = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            long sum = 0;
            while (j != n && a[j].value == a[i].value) {
                sum += ci[a[j].pos];
                j++;
            }
            if (a[i].value != 0) {
                res = gcd(res, sum);
            }
            i = j;
        }
        out.println(res);
    }
}