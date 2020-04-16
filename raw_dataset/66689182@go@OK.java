int[] go(int[] a, int pr) {
    int n = a.length;
    int[] from = new int[2 * n];
    int[] to = new int[2 * n];
    int p = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == pr) {
            if (i + a[i] < n) {
                from[p] = i + a[i];
                to[p] = i;
                p++;
            }
            if (i - a[i] >= 0) {
                from[p] = i - a[i];
                to[p] = i;
                p++;
            }
        }
    }
    int[][] g = packD(n, from, to, p);
    Queue<Integer> q = new ArrayDeque<>();
    int[] d = new int[n];
    Arrays.fill(d, 99999999);
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == (pr ^ 1)) {
            q.add(i);
            d[i] = 0;
        }
    }
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int e : g[cur]) {
            if (d[e] > d[cur] + 1) {
                d[e] = d[cur] + 1;
                q.add(e);
            }
        }
    }
    return d;
}