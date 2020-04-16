public void solve(int testNumber, InputReader in, OutputWriter out) {
    int i, j;
    int n = in.ni();
    int q = in.ni();
    arr = new ArrayList[n];
    visited = new boolean[n];
    parent = new int[n];
    tin = new int[n];
    tout = new int[n];
    dis = new int[n];
    parent[0] = -1;
    for (i = 0; i < n; i++) arr[i] = new ArrayList<Integer>();
    for (i = 0; i < n - 1; i++) {
        int x = in.ni() - 1;
        int y = in.ni() - 1;
        arr[x].add(y);
        arr[y].add(x);
    }
    dfs(0, 0);
    while (q-- != 0) {
        int k = in.ni();
        ETreeQueries.pair[] p = new ETreeQueries.pair[k];
        for (i = 0; i < k; i++) {
            int x = in.ni() - 1;
            p[i] = new ETreeQueries.pair(dis[x], x);
        }
        Arrays.sort(p);
        int index = p[0].y;
        ArrayList<Integer> arr = new ArrayList<>();
        for (i = 0; i < k; i++) {
            if (p[i].y == index || p[i].y == 0)
                arr.add(p[i].y);
            else
                arr.add(parent[p[i].y]);
        }
        // out.println(arr);
        if (check(arr, index))
            out.println("YES");
        else
            out.println("NO");
    }
}