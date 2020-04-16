public static void merge(int[][] arr, int l, int m, int u) {
    int[][] low = new int[m - l + 1][2];
    int[][] upr = new int[u - m][2];
    int i, j = 0, k = 0;
    for (i = l; i <= m; i++) {
        low[i - l][0] = arr[i][0];
        low[i - l][1] = arr[i][1];
    }
    for (i = m + 1; i <= u; i++) {
        upr[i - m - 1][0] = arr[i][0];
        upr[i - m - 1][1] = arr[i][1];
    }
    i = l;
    while ((j < low.length) && (k < upr.length)) {
        if (low[j][0] < upr[k][0]) {
            arr[i][0] = low[j][0];
            arr[i++][1] = low[j++][1];
        } else {
            if (low[j][0] > upr[k][0]) {
                arr[i][0] = upr[k][0];
                arr[i++][1] = upr[k++][1];
            } else {
                if (low[j][1] > upr[k][1]) {
                    arr[i][0] = low[j][0];
                    arr[i++][1] = low[j++][1];
                } else {
                    arr[i][0] = upr[k][0];
                    arr[i++][1] = upr[k++][1];
                }
            }
        }
    }
    while (j < low.length) {
        arr[i][0] = low[j][0];
        arr[i++][1] = low[j++][1];
    }
    while (k < upr.length) {
        arr[i][0] = upr[k][0];
        arr[i++][1] = upr[k++][1];
    }
}