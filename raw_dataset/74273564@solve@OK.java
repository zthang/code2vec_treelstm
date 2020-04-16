private static void solve() throws IOException {
    int t = ni();
    while (t-- > 0) {
        int n = ni();
        int v = -1;
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int k = ni();
            boolean loopFinished = true;
            int[] each_queen_data = new int[k];
            for (int j = 0; j < k; j++) {
                each_queen_data[j] = ni();
            }
            for (int j = 0; j < k; j++) {
                if (!visited[each_queen_data[j]]) {
                    visited[each_queen_data[j]] = true;
                    loopFinished = false;
                    break;
                }
            }
            if (loopFinished) {
                v = i;
            }
        }
        if (v == -1)
            pl("OPTIMAL");
        else {
            pl("IMPROVE");
            int j;
            for (j = 1; j <= n; j++) {
                if (visited[j] == false)
                    break;
            }
            pl(v + 1 + " " + (j));
        }
    }
}