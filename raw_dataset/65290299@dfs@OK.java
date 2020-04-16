public static long dfs(int x, int[] grr, int i, long ans) {
    long tmp = arr[grr[i]][x];
    for (int y : adj[x]) {
        if (y != prr[x]) {
            prr[y] = x;
            i = (i + 1) % 3;
            tmp += dfs(y, grr, i, ans);
        }
    }
    return tmp;
}