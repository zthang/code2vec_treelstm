void solve() {
    int n = scn.nextInt();
    int[] arr = scn.nextIntArray(n);
    int[][] ans = new int[2][n];
    Arrays.fill(ans[0], -1);
    Arrays.fill(ans[1], -1);
    int[] from = new int[2 * n], to = new int[2 * n];
    int pos = 0;
    int[] lol = new int[n];
    Arrays.fill(lol, 100000000);
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
    for (int i = 0; i < n; i++) {
        if (i + arr[i] < n) {
            to[pos] = i;
            from[pos] = i + arr[i];
            pos++;
            if (arr[i + arr[i]] % 2 != arr[i] % 2) {
                lol[i] = 1;
                pq.add(new int[] { i, 1 });
            }
        }
        if (i - arr[i] >= 0) {
            to[pos] = i;
            from[pos] = i - arr[i];
            pos++;
            if (arr[i - arr[i]] % 2 != arr[i] % 2) {
                lol[i] = 1;
                pq.add(new int[] { i, 1 });
            }
        }
    }
    from = Arrays.copyOf(from, pos);
    to = Arrays.copyOf(to, pos);
    int[][] g = packD(n, from, to);
    boolean[] done = new boolean[n];
    while (!pq.isEmpty()) {
        int[] rv = pq.poll();
        int u = rv[0], w = rv[1];
        if (done[u]) {
            continue;
        }
        done[u] = true;
        for (int v : g[u]) {
            if (1 + w < lol[v]) {
                lol[v] = 1 + w;
                pq.add(new int[] { v, lol[v] });
            }
        }
    }
    for (int i = 0; i < n; i++) {
        if (done[i]) {
            out.print(lol[i] + " ");
        } else {
            out.print(-1 + " ");
        }
    }
    out.println();
}