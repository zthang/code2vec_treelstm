public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();
    long[][] c = new long[3][n];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < n; j++) {
            c[i][j] = in.nextLong();
        }
    }
    List<Integer>[] adj = new List[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    int sz1 = 0;
    for (int i = 0; i < n; i++) {
        if (adj[i].size() == 1)
            sz1 = i;
        if (adj[i].size() > 2) {
            out.println(-1);
            return;
        }
    }
    List<Integer> v = new ArrayList<>();
    boolean[] vis = new boolean[n];
    vis[sz1] = true;
    v.add(sz1);
    dfs(vis, adj, v, sz1);
    long res = Long.MAX_VALUE;
    Map<Integer, Integer> hm = new HashMap<>();
    int[][] itr = new int[6][3];
    itr[0] = new int[] { 1, 2, 3 };
    itr[1] = new int[] { 2, 3, 1 };
    itr[2] = new int[] { 3, 1, 2 };
    itr[3] = new int[] { 1, 3, 2 };
    itr[4] = new int[] { 3, 2, 1 };
    itr[5] = new int[] { 2, 1, 3 };
    for (int i = 0; i < 6; i++) {
        long sum = 0;
        Map<Integer, Integer> temp = new HashMap<>();
        for (int j = 0; j < n; j++) {
            int num = v.get(j);
            sum += c[itr[i][j % 3] - 1][num];
            temp.put(num, itr[i][j % 3]);
        }
        if (sum < res) {
            res = sum;
            hm = temp;
        }
    }
    out.println(res);
    for (int i = 0; i < n; i++) {
        out.print(hm.get(i) + " ");
    }
}