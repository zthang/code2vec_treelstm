void solve() {
    StringBuffer sb = new StringBuffer();
    int N = ni();
    int[][] a = na(N, 2);
    int[][] s = new int[N][];
    for (int i = 0; i < N; i++) {
        s[i] = new int[] { a[i][0], i };
    }
    Comparator<int[]> c = new Comparator<int[]>() {

        public int compare(int[] arg0, int[] arg1) {
            int ret = arg0[0] - arg1[0];
            if (ret == 0)
                ret = arg0[0] - arg1[0];
            return ret;
        }
    };
    Arrays.sort(s, c);
    p = new int[N];
    for (int i = 0; i < N; i++) p[i] = i;
    int nEdges = 0;
    TreeSet<int[]> set = new TreeSet<int[]>(c);
    outer: for (int[] s1 : s) {
        int u = s1[1];
        // tr(">", u, a[u]);
        List<int[]> l = new ArrayList<int[]>();
        Iterator<int[]> iter = set.iterator();
        while (iter.hasNext()) {
            int[] s0 = iter.next();
            int v = s0[1];
            if (a[v][1] < a[u][0])
                iter.remove();
            else if (a[v][1] >= a[u][1]) {
                break;
            } else {
                if (!merge(u, v)) {
                    nEdges = -1;
                    break outer;
                }
                nEdges++;
            // tr(v + 1, u + 1, a[v], a[u], nEdges);
            }
        }
        set.add(new int[] { a[u][1], u });
    }
    out.println(nEdges == N - 1 ? "YES" : "NO");
}