void chack_valid() {
    boolean[][] avaia = new boolean[7][7];
    for (int i = 1; i <= 6; i++) {
        for (int j = 1; j <= 6; j++) {
            avaia[i][j] = true;
        }
    }
    boolean f = true;
    int count = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            if (mat[i][j]) {
                if (arr[i] == 0 && arr[j] == 0)
                    continue;
                if (arr[i] == 0 && arr[j] != 0)
                    f = false;
                if (arr[i] != 0 && arr[j] == 0)
                    f = false;
                if (avaia[arr[i]][arr[j]] || avaia[arr[j]][arr[i]]) {
                    count++;
                    avaia[arr[i]][arr[j]] = avaia[arr[j]][arr[i]] = false;
                } else {
                }
            }
        }
    }
    if (f)
        ans = Math.max(ans, count);
}