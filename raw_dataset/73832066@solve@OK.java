public void solve(int testNumber, Scanner sc, PrintWriter pw) {
    int n = sc.nextInt();
    int[] arr = new int[n];
    ArrayList<Integer>[] adjL = new ArrayList[n];
    for (int i = 0; i < n; i++) adjL[i] = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        if (arr[i] + i < n)
            adjL[arr[i] + i].add(i);
        if (i - arr[i] >= 0)
            adjL[i - arr[i]].add(i);
    }
    HashSet<Integer> even = new HashSet<>(), odd = new HashSet<>();
    for (int i = 0; i < n; i++) if (arr[i] % 2 == 0)
        even.add(i);
    else
        odd.add(i);
    Queue<Integer> q = new LinkedList<>(), dist = new LinkedList<>(), val = new LinkedList<>();
    for (int x : odd) {
        q.add(x);
        dist.add(0);
        val.add(x);
    }
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    boolean[] vis = new boolean[n];
    int c = 0;
    while (!q.isEmpty()) {
        int cur = q.poll();
        int dis = dist.poll();
        if (vis[cur])
            continue;
        vis[cur] = true;
        if (even.contains(cur)) {
            if (ans[cur] == -1)
                ans[cur] = dis;
        }
        for (int u : adjL[cur]) {
            q.add(u);
            dist.add(dis + 1);
        }
    }
    q = new LinkedList<>();
    dist = new LinkedList<>();
    val = new LinkedList<>();
    for (int x : even) {
        q.add(x);
        dist.add(0);
        val.add(x);
    }
    vis = new boolean[n];
    while (!q.isEmpty()) {
        int cur = q.poll();
        int dis = dist.poll();
        if (vis[cur])
            continue;
        vis[cur] = true;
        if (odd.contains(cur)) {
            if (ans[cur] == -1)
                ans[cur] = dis;
        }
        for (int u : adjL[cur]) {
            q.add(u);
            dist.add(dis + 1);
        }
    }
    for (int x : ans) pw.print(x + " ");
}