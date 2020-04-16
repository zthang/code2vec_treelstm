public final void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    TreeSet<Integer>[] a = new TreeSet[n + 1];
    TreeSet<Integer> unused = new TreeSet<>();
    for (int i = 1; i <= n; i++) {
        a[i] = new TreeSet<>();
        unused.add(i);
    }
    for (int[] e : in.nextIntMatrix(m, 2)) {
        a[e[0]].add(e[1]);
        a[e[1]].add(e[0]);
    }
    int ans = 0;
    int[] queue = new int[n + 1];
    int addPt = 0, pollPt = 0;
    for (int i = 1; i <= n; i++) {
        if (unused.remove(i)) {
            queue[addPt++] = i;
            while (pollPt < addPt) {
                int u = queue[pollPt++];
                int cur = addPt;
                for (int v : unused) {
                    if (!a[u].contains(v)) {
                        queue[addPt++] = v;
                    }
                }
                for (int j = cur; j < addPt; j++) {
                    unused.remove(queue[j]);
                }
            }
            ++ans;
        }
    }
    out.println(ans - 1);
}