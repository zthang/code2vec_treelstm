void solve() {
    int n = ni(), m = ni();
    int[] from = new int[10 * m + 2];
    int[] to = new int[10 * m + 2];
    int[] ws = new int[10 * m + 2];
    int p = 0;
    int gen = n;
    for (int i = 0; i < m; i++) {
        int f = ni() - 1, t = ni() - 1;
        char[] s = ("" + (i + 1)).toCharArray();
        int cur = f;
        for (int j = 0; j < s.length; j++) {
            char c = s[j];
            from[p] = cur;
            to[p] = j == s.length - 1 ? t : gen++;
            ws[p] = c - '0';
            cur = to[p];
            p++;
        }
        cur = t;
        for (int j = 0; j < s.length; j++) {
            char c = s[j];
            from[p] = cur;
            to[p] = j == s.length - 1 ? f : gen++;
            ws[p] = c - '0';
            cur = to[p];
            p++;
        }
    }
    int[][][] g = packWD(gen, from, to, ws, p);
    for (int[][] row : g) {
        Arrays.sort(row, new Comparator<int[]>() {

            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
    }
    int[] ds = new int[gen];
    int I = 99999999;
    Arrays.fill(ds, I);
    ds[0] = 0;
    int mod = 1000000007;
    long[] vals = new long[gen];
    Queue<Queue<Integer>> qs = new ArrayDeque<>();
    {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        qs.add(q);
    }
    while (!qs.isEmpty()) {
        Queue<Integer> q = qs.poll();
        List<int[]> ns = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] e : g[cur]) {
                if (ds[e[0]] == I) {
                    ns.add(new int[] { e[0], e[1], cur });
                }
            }
        }
        Collections.sort(ns, new Comparator<int[]>() {

            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int pre = -1;
        Queue<Integer> pack = new ArrayDeque<>();
        for (int[] e : ns) {
            if (ds[e[0]] == I) {
                if (e[1] != pre && !pack.isEmpty()) {
                    qs.add(pack);
                    pack = new ArrayDeque<>();
                }
                pre = e[1];
                ds[e[0]] = ds[e[2]] + 1;
                vals[e[0]] = (vals[e[2]] * 10 + e[1]) % mod;
                pack.add(e[0]);
            }
        }
        if (!pack.isEmpty()) {
            qs.add(pack);
        }
    }
    for (int i = 1; i < n; i++) {
        out.println(vals[i]);
    }
}