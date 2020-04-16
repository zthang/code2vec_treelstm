void solve() {
    int t = in.nextInt();
    boolean[] used = new boolean[100005];
    MAIN: for (int i = 0; i < t; i++) {
        int n = in.nextInt();
        for (int j = 0; j < n; j++) used[j] = false;
        int[][] g = new int[n][];
        int[] k = new int[n];
        for (int j = 0; j < n; j++) {
            k[j] = in.nextInt();
            g[j] = new int[k[j]];
            for (int l = 0; l < k[j]; l++) {
                g[j][l] = in.nextInt() - 1;
            }
        }
        int idx = -1;
        LOOP: for (int j = 0; j < n; j++) {
            for (int l = 0; l < k[j]; l++) {
                if (!used[g[j][l]]) {
                    used[g[j][l]] = true;
                    continue LOOP;
                }
            }
            idx = j;
        }
        if (idx == -1) {
            out.println("OPTIMAL");
        } else {
            out.println("IMPROVE");
            for (int l = 0; l < n; l++) {
                if (!used[l]) {
                    out.println((idx + 1) + " " + (l + 1));
                    continue MAIN;
                }
            }
        }
    }
}