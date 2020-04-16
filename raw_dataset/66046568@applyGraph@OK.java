private void applyGraph(int[][] dp) {
    int a = nextInt();
    int[] p = new int[a];
    int[] ch = new int[a];
    for (int i = 1; i < a; i++) {
        p[i] = nextInt() - 1;
        ch[p[i]]++;
    }
    int[] child = new int[n];
    for (int i = 0; i < n; i++) {
        child[i] = nextInt() - 1;
    }
    for (int i = 0; i < n; i++) {
        int[] c = Arrays.copyOf(ch, ch.length);
        int cnt = 0;
        for (int j = i; j < n; j++) {
            int curr = child[j];
            while (curr != 0 && c[curr] == 0) {
                curr = p[curr];
                c[curr]--;
                ++cnt;
            }
            dp[i][j + 1] = Math.max(dp[i][j + 1], cnt);
        }
    }
}