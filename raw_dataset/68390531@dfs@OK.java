public static long dfs(ArrayList<Integer>[] brr, long[][] arr, int[] visited, int curr, int ccurr, int croot, int[] ans) {
    visited[curr] = 1;
    long cost = arr[ccurr][curr];
    ans[curr] = ccurr;
    for (int i = 0; i < brr[curr].size(); i++) {
        int now = brr[curr].get(i);
        if (visited[now] == 0) {
            int cn = -1;
            if (ccurr == 0 && croot == 1 || ccurr == 1 && croot == 0) {
                cn = 2;
            } else if (ccurr == 0 && croot == 2 || ccurr == 2 && croot == 0) {
                cn = 1;
            } else if (ccurr == 1 && croot == 2 || ccurr == 2 && croot == 1) {
                cn = 0;
            }
            cost = cost + dfs(brr, arr, visited, now, cn, ccurr, ans);
        }
    }
    return cost;
}