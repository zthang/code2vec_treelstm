public static int dp(int remw, int i) {
    if (i == m) {
        return (remw / c0) * d0;
    }
    if (memo[remw][i] != -1) {
        return memo[remw][i];
    }
    int total = dp(remw, i + 1);
    for (int j = 0; j <= a[i]; j++) {
        if (remw - (c[i] * j) >= 0) {
            total = Math.max(dp(remw - ((c[i] * j)), i + 1) + (d[i] * j), total);
            if (c[i] * j == 270) {
                System.out.println("this" + " " + remw + " " + total + " " + c[i] + " " + j + " " + d[i] + " ");
            }
        }
    }
    return memo[remw][i] = total;
}