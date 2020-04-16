private static int ans(int[] a, int[][] adja, int index, int n) {
    if (index == n + 1) {
        boolean[][] dominos = new boolean[7][7];
        for (int i = 1; i <= n; i++) {
            for (int j : adja[i]) {
                dominos[a[i]][a[j]] = true;
            }
        }
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                count += dominos[i][j] ? 1 : 0;
            }
        }
        return count;
    } else {
        int max = 0;
        for (int i = 1; i <= 6; i++) {
            a[index] = i;
            max = Math.max(max, ans(a, adja, index + 1, n));
        }
        return max;
    }
}