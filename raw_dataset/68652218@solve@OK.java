void solve() {
    int n = ni();
    long[] x = new long[n];
    long[] y = new long[n];
    for (int i = 0; i < n; ++i) {
        x[i] = nl();
        y[i] = nl();
    }
    long[] c = nal(n);
    long[] k = nal(n);
    int m = n * (n - 1) / 2 + n;
    long[][] egs = new long[m][3];
    int g = 0;
    init(n + 1);
    for (int i = 0; i < n; ++i) {
        egs[g][0] = c[i];
        egs[g][1] = i;
        egs[g][2] = n;
        g++;
        for (int j = i + 1; j < n; ++j) {
            egs[g][0] = (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j])) * (k[i] + k[j]);
            egs[g][1] = i;
            egs[g][2] = j;
            g++;
        }
    }
    long s = 0;
    int d = 0;
    List<Integer> li = new ArrayList<>();
    List<int[]> eli = new ArrayList<>();
    Arrays.sort(egs, (xx, yy) -> {
        return Long.compare(xx[0], yy[0]);
    });
    for (int i = 0; i < m; ++i) {
        int u = (int) egs[i][1];
        int v = (int) egs[i][2];
        if (root(u) != root(v)) {
            if (u == n || v == n) {
                d++;
                li.add(u + v - n + 1);
            } else {
                eli.add(new int[] { u + 1, v + 1 });
            }
            combine(u, v);
            s += egs[i][0];
        }
    }
    println(s);
    println(d);
    for (int u = 0; u < li.size(); ++u) {
        print(li.get(u));
        if (u != li.size() - 1) {
            print(" ");
        }
    }
    println();
    println(eli.size());
    for (int u = 0; u < eli.size(); ++u) {
        println(eli.get(u)[0] + " " + eli.get(u)[1]);
    }
}