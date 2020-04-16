void solve() {
    int n = scn.nextInt(), m = scn.nextInt(), k = scn.nextInt();
    int[] arr = scn.nextIntArray(k);
    for (int i = 0; i < k; i++) {
        arr[i]--;
    }
    int[] from = new int[m], to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
    }
    int[][] g = packU(n, from, to);
    int[] dist1 = dist(g, 0);
    int[] dist2 = dist(g, n - 1);
    int[][] need = new int[k][2];
    for (int i = 0; i < k; i++) {
        need[i][0] = arr[i];
        need[i][1] = dist1[arr[i]];
    }
    Arrays.parallelSort(need, (o1, o2) -> o1[1] - o2[1]);
    int ans = 0;
    for (int i = 1; i < k; i++) {
        ans = Math.max(ans, 1 + dist1[need[i - 1][0]] + dist2[need[i][0]]);
    }
    ans = Math.min(ans, dist1[n - 1]);
    out.println(ans);
}