void solve() {
    int n = ni();
    int m = ni();
    int[][] g = creategraph(n, n - 1);
    int[] parent = new int[n + 1];
    int[][] time = new int[n + 1][2];
    dfs(g, 1, new boolean[n + 1], parent, time);
    parent[1] = 1;
    while (m-- > 0) {
        int k = ni();
        int[] arr = na(k);
        int[][] t = new int[k][2];
        for (int i = 0; i < k; i++) {
            t[i][0] = time[parent[arr[i]]][0];
            t[i][1] = time[parent[arr[i]]][1];
        }
        Arrays.sort(t, new Comparator<int[]>() {

            public int compare(int[] x, int[] y) {
                return x[0] - y[0];
            }
        });
        // for(int i[] : t) {
        // out.println(i[0]+" "+i[1]);
        // }
        boolean flag = true;
        for (int i = 0; i < k - 1; i++) {
            if (t[i][0] <= t[i + 1][0] && t[i + 1][1] <= t[i][1])
                continue;
            else {
                flag = false;
                break;
            }
        }
        if (!flag) {
            out.println("NO");
        } else {
            out.println("YES");
        }
    }
}