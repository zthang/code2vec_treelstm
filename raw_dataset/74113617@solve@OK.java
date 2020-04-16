// solution credits : Ayush Kumar
void solve(int TC) {
    int n = ni();
    int[][] b = new int[n][];
    for (int i = 0; i < n; i++) {
        int s = ni();
        b[i] = new int[s];
        for (int j = 0; j < s; j++) b[i][j] = ni();
    }
    int[] f = new int[n + 1];
    int ansi = 0, ansj = 0;
    for (int i = 0; i < b.length; i++) {
        boolean done = false;
        for (int j = 0; j < b[i].length; j++) {
            if (f[b[i][j]] == 0) {
                if (ansj == b[i][j]) {
                    for (int x = ansj + 1; x <= n; x++) if (f[x] == 0) {
                        ansj = x;
                        break;
                    }
                }
                f[b[i][j]]++;
                done = true;
                break;
            }
        }
        if (!done && ansi == 0) {
            ansi = i + 1;
            for (int x = ansj + 1; x <= n; x++) if (f[x] == 0) {
                ansj = x;
                break;
            }
        }
    }
    p(ansi != 0 ? "IMPROVE\n" + ansi + " " + ansj : "OPTIMAL");
}