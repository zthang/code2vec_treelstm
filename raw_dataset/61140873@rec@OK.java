public static int rec(int n, int m, int k, int[] values, int[][] edges) {
    if (k == n) {
        int[][] taken = new int[7][7];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (taken[values[edges[i][0]]][values[edges[i][1]]] == 0) {
                taken[values[edges[i][0]]][values[edges[i][1]]] = 1;
                taken[values[edges[i][1]]][values[edges[i][0]]] = 1;
                count++;
            }
        }
        return count;
    }
    int max = -1;
    for (int i = 1; i < 6; i++) {
        values[k] = i;
        int res = rec(n, m, k + 1, values, edges);
        if (res > max) {
            max = res;
        }
    }
    return max;
}