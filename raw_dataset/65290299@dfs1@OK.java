public static long dfs1(int x, int[] grr, int i, long ans) {
    drr[x] = grr[i] + 1;
    long tmp = arr[grr[i]][x];
    for (int y : adj[x]) {
        if (y != prr[x]) {
            prr[y] = x;
            i = (i + 1) % 3;
            tmp += dfs1(y, grr, i, ans);
        }
    }
    return tmp;
}