private static void permutation(int l, int r) {
    if (l == r) {
        int cnt = 0;
        boolean[][] dominoesUsed = new boolean[7][7];
        for (int i = 0; i < n; i++) {
            for (int curr : adj[i]) {
                if (!dominoesUsed[a[i]][a[curr]]) {
                    cnt++;
                    dominoesUsed[a[i]][a[curr]] = true;
                    dominoesUsed[a[curr]][a[i]] = true;
                }
            }
        }
        ans = Math.max(ans, cnt);
    } else {
        for (int i = l; i <= r; i++) {
            // swap
            int temp = a[l];
            a[l] = a[i];
            a[i] = temp;
            permutation(l + 1, r);
            // backtrack
            temp = a[l];
            a[l] = a[i];
            a[i] = temp;
        }
    }
}