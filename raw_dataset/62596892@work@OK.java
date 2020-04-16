void work() {
    int n = in.nextInt();
    long[][] cost = new long[4][n + 1];
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= n; j++) {
            cost[i][j] = in.nextLong();
        }
    }
    int[] degree = new int[n + 1];
    ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        degree[n1]++;
        degree[n2]++;
        graph[n1].add(n2);
        graph[n2].add(n1);
    }
    int s = 0;
    for (int i = 1; i <= n; i++) {
        if (degree[i] == 1)
            s = i;
        if (degree[i] > 2) {
            out.println(-1);
            return;
        }
    }
    int[] color = new int[n + 1];
    long min = Long.MAX_VALUE;
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            if (i == j)
                continue;
            int[] ncolor = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            long cnt = 0;
            for (int k = 1, p = s, pre = 0, cur = 0; k <= n; k++) {
                int nc = 0;
                if (k == 1) {
                    nc = i;
                    pre = i;
                } else if (k == 2) {
                    nc = j;
                    cur = j;
                } else {
                    for (int l = 1; l <= 3; l++) {
                        if (l != pre && l != cur) {
                            nc = l;
                            break;
                        }
                    }
                    pre = cur;
                    cur = nc;
                }
                ncolor[p] = nc;
                cnt += cost[nc][p];
                visited[p] = true;
                for (int nn : graph[p]) {
                    if (!visited[nn]) {
                        p = nn;
                    }
                }
            }
            if (cnt < min) {
                min = cnt;
                color = ncolor;
            }
        }
    }
    out.println(min);
    for (int i = 1; i <= n; i++) {
        out.print(color[i] + " ");
    }
}