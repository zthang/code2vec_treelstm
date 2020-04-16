public static void merge(int[] arr, int l, int m, int u) {
    int[] low = new int[m - l + 1];
    int[] upr = new int[u - m];
    int i, j = 0, k = 0;
    for (i = l; i <= m; i++) low[i - l] = arr[i];
    for (i = m + 1; i <= u; i++) upr[i - m - 1] = arr[i];
    i = l;
    while ((j < low.length) && (k < upr.length)) {
        if (lvl[low[j]] < lvl[upr[k]])
            arr[i++] = low[j++];
        else
            arr[i++] = upr[k++];
    }
    while (j < low.length) arr[i++] = low[j++];
    while (k < upr.length) arr[i++] = upr[k++];
}