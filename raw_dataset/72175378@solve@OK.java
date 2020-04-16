static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int n = ni(), m = ni();
    ArrayList<Integer>[] adj = new ArrayList[n + 1];
    ArrayList<Integer>[] radj = new ArrayList[n + 1];
    for (int i = 1; i <= n; ++i) {
        adj[i] = new ArrayList<>();
        radj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; ++i) {
        int u = ni(), v = ni();
        adj[u].add(v);
        radj[v].add(u);
    }
    int k = ni();
    int[] arr = new int[k];
    for (int i = 0; i < k; ++i) {
        arr[i] = ni();
    }
    int[] min_dis = new int[n + 1];
    Arrays.fill(min_dis, Integer.MAX_VALUE);
    min_dis[arr[k - 1]] = 0;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.addLast(arr[k - 1]);
    while (!queue.isEmpty()) {
        int curr = queue.pollFirst();
        for (int e : radj[curr]) {
            if (min_dis[e] == Integer.MAX_VALUE) {
                min_dis[e] = min_dis[curr] + 1;
                queue.addLast(e);
            }
        }
    }
    // pa("min_dis", min_dis);
    int min = 0, max = 0;
    for (int i = 0; i < k; ++i) {
        int v = arr[i];
        if (i + 1 < k) {
            int next = arr[i + 1];
            if (min_dis[next] != min_dis[v] - 1) {
                min++;
            }
            boolean flag = false;
            for (int e : adj[v]) {
                if (e != next && min_dis[e] == min_dis[v] - 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                ++max;
            }
        }
    }
    pl(min + " " + max);
    pw.flush();
    pw.close();
}