static int solve(int pos, int[] color) {
    if (pos == 7) {
        int sol = 0;
        // io.println();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (adjMat[i][j] == 1) {
                    if (taken[color[i]][color[j]] == 0) {
                        sol++;
                    }
                    taken[color[i]][color[j]] = 1;
                    taken[color[j]][color[i]] = 1;
                }
            }
        }
        taken = new int[7][7];
        // io.println(sol);
        return sol;
    }
    int ans = 0;
    for (int i = 1; i <= 6; i++) {
        color[pos] = i;
        ans = Math.max(ans, solve(pos + 1, color));
        color[pos] = 0;
    }
    return ans;
}