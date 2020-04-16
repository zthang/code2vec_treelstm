private int calc(int[] c, int[][] gr) {
    int ans = 0;
    boolean[][] used = new boolean[6][6];
    for (int i = 0; i < gr.length; i++) {
        for (int j = 0; j < gr[i].length; j++) {
            if (gr[i][j] == 1) {
                if (!used[Math.min(c[i] - 1, c[j] - 1)][Math.max(c[i] - 1, c[j] - 1)]) {
                    used[Math.min(c[i] - 1, c[j] - 1)][Math.max(c[i] - 1, c[j] - 1)] = true;
                    ans++;
                }
            }
        }
    }
    return ans;
}