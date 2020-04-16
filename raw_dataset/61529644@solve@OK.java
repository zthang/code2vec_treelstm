public void solve(int testNumber, InputReader sc, PrintWriter out) throws IOException {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] d = new int[n + 1];
    TreeSet<Integer>[] edge = new TreeSet[n + 1];
    for (int i = 0; i <= n; i++) edge[i] = new TreeSet<Integer>();
    for (int i = 0; i < m; i++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        edge[x].add(y);
        edge[y].add(x);
    }
    HashSet<Long>[] set = new HashSet[3];
    for (int i = 0; i < 3; i++) set[i] = new HashSet<Long>();
    long[][] s = new long[n + 1][3];
    for (int i = 1; i <= n; i++) {
        for (int v : edge[i]) {
            for (int j = 0; j < 3; j++) {
                s[i][j] = (s[i][j] * Base[j] + v) % Mod[j];
            }
        }
        for (int j = 0; j < 3; j++) {
            set[j].add(s[i][j]);
            if (set[j].size() > 3) {
                out.println("-1");
                return;
            }
        }
    }
    for (int i = 0; i < 3; i++) {
        if (set[i].size() != 3) {
            out.println("-1");
            return;
        }
    }
    ArrayList<Long> buf = new ArrayList<Long>();
    long[] cnt = new long[3];
    for (long v : set[0]) buf.add(v);
    StringBuilder res = new StringBuilder();
    for (int i = 1; i <= n; i++) {
        if (s[i][0] == buf.get(0)) {
            res.append("1 ");
            cnt[0]++;
        } else if (s[i][0] == buf.get(1)) {
            res.append("2 ");
            cnt[1]++;
        } else {
            res.append("3 ");
            cnt[2]++;
        }
    }
    if (cnt[0] * cnt[1] + cnt[0] * cnt[2] + cnt[1] * cnt[2] != m) {
        out.println("-1");
        return;
    }
    out.println(res);
}