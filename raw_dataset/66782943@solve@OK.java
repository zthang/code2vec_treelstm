public void solve(int testNumber, InputReader s, PrintWriter w) {
    int n = s.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = s.nextInt();
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    int[] level = new int[n];
    Arrays.fill(level, -1);
    for (int i = 0; i < n; i++) {
        if (i - a[i] >= 0) {
            if (a[i - a[i]] % 2 != a[i] % 2) {
                if (level[i] == -1) {
                    q.add(i);
                    level[i] = 1;
                }
            } else
                adj[i - a[i]].add(i);
        }
        if (i + a[i] < n) {
            if (a[i + a[i]] % 2 != a[i] % 2) {
                if (level[i] == -1) {
                    q.add(i);
                    level[i] = 1;
                }
            } else
                adj[i + a[i]].add(i);
        }
    }
    while (!q.isEmpty()) {
        int x = q.poll();
        for (int y : adj[x]) {
            if (level[y] == -1) {
                q.add(y);
                level[y] = level[x] + 1;
            }
        }
    }
    for (int i = 0; i < n; i++) w.print(level[i] + " ");
    w.println();
}