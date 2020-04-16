static void solve(Scanner sc, PrintWriter pw) throws IOException {
    int n = sc.nextInt(), m = sc.nextInt(), k = 0, path[] = null;
    List<Integer>[] asc = new LinkedList[n + 1], nxt = new LinkedList[n + 1];
    for (int i = 1; i <= n; i++) {
        asc[i] = new LinkedList<>();
        nxt[i] = new LinkedList<>();
    }
    for (int i = 0; i < m; i++) {
        int first = sc.nextInt(), second = sc.nextInt();
        asc[second].add(first);
        nxt[first].add(second);
    }
    k = sc.nextInt();
    path = new int[k];
    for (int i = 0; i < k; i++) {
        path[i] = sc.nextInt();
    }
    Queue<Integer> q = new LinkedList<>();
    int[] dst = new int[n + 1];
    Arrays.fill(dst, Integer.MAX_VALUE);
    // Set<Integer> nxt[] = new HashSet[n + 1];
    // for (int i = 1; i <= n; i++) {
    // // nxt[i] = new HashSet<>();
    // }
    q.add(path[k - 1]);
    dst[path[k - 1]] = 0;
    // }
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int i : asc[cur]) {
            if (dst[i] <= dst[cur] + 1) {
                continue;
            }
            q.add(i);
            dst[i] = dst[cur] + 1;
            int c = 0;
        }
    }
    int mx = 0, mn = 0;
    for (int i = 0; i < k - 1; i++) {
        int c = path[i + 1];
        if (dst[c] >= dst[path[i]]) {
            mn++;
            mx++;
            continue;
        }
        int count = 0;
        for (int a : nxt[path[i]]) {
            if (dst[a] == dst[c]) {
                count++;
                if (count > 1) {
                    mx++;
                    break;
                }
            }
        }
    }
    // pw.println(dst[1]);
    pw.println(mn + " " + mx);
}