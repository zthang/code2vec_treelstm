void solve() {
    for (int T = ni(); T > 0; T--) {
        int n = ni();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = na(ni());
            for (int j = 0; j < a[i].length; j++) a[i][j]--;
        }
        int[] mat = new int[n];
        int[] rmat = new int[n];
        Arrays.fill(mat, -1);
        Set<Integer> done = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int v : a[i]) {
                if (done.add(v)) {
                    mat[i] = v;
                    rmat[v] = i;
                    break;
                }
            }
        }
        if (done.size() == n) {
            out.println("OPTIMAL");
        } else {
            out.println("IMPROVE");
            for (int i = 0; i < n; i++) {
                if (mat[i] == -1) {
                    out.print((i + 1) + " ");
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (!done.contains(i)) {
                    out.print(i + 1);
                    out.println();
                    break;
                }
            }
        }
    }
}