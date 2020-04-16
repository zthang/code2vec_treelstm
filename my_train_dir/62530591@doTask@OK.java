public static void doTask() {
    int n = sc.nextInt();
    long[][] cost = new long[n][3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < n; j++) {
            cost[j][i] = sc.nextLong();
        }
    }
    int[][] neigbs = new int[n][4];
    int[] number = new int[n];
    boolean can = true;
    for (int i = 0; i < n - 1; i++) {
        int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
        neigbs[u][number[u]] = v;
        neigbs[v][number[v]] = u;
        number[u]++;
        number[v]++;
        if (number[u] > 2 || number[v] > 2) {
            can = false;
            break;
        }
    }
    if (can) {
        int first = 0;
        while (number[first] > 1) first++;
        int[] idx = new int[n];
        int[] revidx = new int[n];
        boolean[] used = new boolean[n];
        used[first] = true;
        int index = 0;
        while (index < n) {
            idx[index] = first;
            revidx[first] = index;
            index++;
            // if (index<n) {
            first = !used[neigbs[first][0]] ? neigbs[first][0] : neigbs[first][1];
            used[first] = true;
        // }
        }
        int bestOpts = -1;
        long minResut = 1_500_000_000_000_000_000L;
        for (int j = 0; j < 6; j++) {
            int[] opt = opts[j];
            long res = 0;
            for (int i = 0; i < n; i++) {
                int v = idx[i];
                res += cost[v][opt[i % 3]];
            }
            if (bestOpts == -1 || res < minResut) {
                minResut = res;
                bestOpts = j;
            }
        }
        out.println(minResut);
        for (int i = 0; i < n; i++) {
            int resIdx = opts[bestOpts][revidx[i] % 3] + 1;
            out.print(resIdx + " ");
        }
    } else {
        out.println(-1);
    }
}