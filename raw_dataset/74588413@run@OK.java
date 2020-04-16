public void run() {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int n = in.nextInt();
    int m = in.nextInt();
    int i, j, k;
    ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    for (i = 0; i < n; i++) {
        g.add(new ArrayList<>());
    }
    for (i = 0; i < n - 1; i++) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        g.get(u).add(v);
        g.get(v).add(u);
    }
    parent = new int[n];
    depth = new int[n];
    time_in = new int[n];
    time_out = new int[n];
    DFS(0, -1, 0, g);
    for (j = 0; j < m; j++) {
        k = in.nextInt();
        int[] arr = new int[k];
        for (i = 0; i < k; i++) {
            arr[i] = in.nextInt();
            arr[i] = arr[i] - 1;
        }
        int u = arr[0];
        for (int it : arr) {
            if (depth[u] < depth[it]) {
                u = it;
            }
        }
        for (i = 0; i < k; i++) {
            if (arr[i] == u) {
                continue;
            }
            if (parent[arr[i]] != -1) {
                arr[i] = parent[arr[i]];
            }
        }
        boolean isValid = true;
        for (int it : arr) {
            isValid = isAncestor(it, u);
            if (isValid) {
                continue;
            } else {
                break;
            }
        }
        if (isValid) {
            w.println("YES");
        } else {
            w.println("NO");
        }
    }
    w.flush();
    w.close();
}