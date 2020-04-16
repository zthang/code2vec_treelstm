public int[] go(int[] a, boolean odd) {
    int n = a.length;
    int[] from = new int[2 * n];
    int[] to = new int[2 * n];
    int p = 0;
    for (int i = 0; i < n; i++) {
        if (i - a[i] >= 0) {
            from[p] = i - a[i];
            to[p++] = i;
        }
        if (i + a[i] < n) {
            from[p] = i + a[i];
            to[p++] = i;
        }
    }
    int[][] g = packD(n, from, to, p);
    int[] d = new int[n];
    Arrays.fill(d, 99999999);
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        if ((a[i] % 2 == 1) == odd) {
            q.add(i);
            d[i] = 0;
        }
    }
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int nex : g[cur]) {
            if (d[nex] > d[cur] + 1) {
                d[nex] = d[cur] + 1;
                q.add(nex);
            }
        }
    }
    return d;
}